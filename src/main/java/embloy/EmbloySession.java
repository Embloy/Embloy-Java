package embloy;

public class EmbloySession {
    private final EmbloyRequestMode mode;
    private final String jobSlug;
    private final String successUrl;
    private final String cancelUrl;

    public EmbloySession(EmbloyRequestMode mode, String jobSlug, String successUrl, String cancelUrl) {
        this.mode = mode;
        this.jobSlug = jobSlug;
        this.successUrl = successUrl;
        this.cancelUrl = cancelUrl;
    }

    public EmbloyRequestMode getMode() {
        return mode;
    }

    public String getJobSlug() {
        return jobSlug;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public enum EmbloyRequestMode {
        JOB_MODE("job"),
        ASHBY_MODE("ashby"),
        LEVER_MODE("lever"),
        SOFTGARDEN_MODE("softgarden"),
        GREENHOUSE_MODE("greenhouse");

        private final String value;

        EmbloyRequestMode(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static EmbloyRequestMode fromValue(String value) {
            for (EmbloyRequestMode mode : values()) {
                if (mode.getValue().equals(value)) {
                    return mode;
                }
            }
            throw new IllegalArgumentException("Unknown value: " + value);
        }
    }
}