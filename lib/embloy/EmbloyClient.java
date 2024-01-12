package embloy;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmbloyClient {
    private final String clientToken;
    private final EmbloySession session;
    private final String baseUrl;
    private final String apiVersion;

    private static final String ENDPOINT_TEMPLATE = "%s/%s/sdk/request/auth/token";

    public EmbloyClient(String clientToken, EmbloySession session) {
        this.clientToken = clientToken;
        this.session = session;
        this.baseUrl = "https://api.embloy.com";
        this.apiVersion = "api/v0";
    }

    public String makeRequest() throws Exception {
        String endpoint = String.format(ENDPOINT_TEMPLATE, baseUrl, apiVersion);
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set up the request
        connection.setRequestMethod("POST");
        connection.setRequestProperty("client_token", clientToken);
        connection.setDoOutput(true);

        // Prepare data for the request
        Map<String, String> requestData = new HashMap<>();
        requestData.put("mode", session.getMode().getValue().toString());
        requestData.put("success_url", session.getSuccessUrl());
        requestData.put("cancel_url", session.getCancelUrl());
        requestData.put("job_slug", session.getJobSlug());

        // Write the data to the request
        try (OutputStream os = connection.getOutputStream()) {
            os.write(getFormDataString(requestData).getBytes());
            os.flush();
        }

        // Handle the response
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (Scanner scanner = new Scanner(connection.getInputStream())) {
                return scanner.useDelimiter("\\A").next();
            } catch (Exception e) {
                throw new Exception("Error reading response: " + e.getMessage(), e);
            }
        } else {
            throw new Exception("Error making request: " + responseCode);
        }
    }

    private String getFormDataString(Map<String, String> data) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            if (result.length() > 0) {
                result.append("&");
            }
            result.append(encode(entry.getKey())).append("=").append(encode(entry.getValue()));
        }
        return result.toString();
    }

    private String encode(String value) {
        try {
            return java.net.URLEncoder.encode(value, "UTF-8");
        } catch (java.io.UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
