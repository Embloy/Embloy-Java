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
        JOB_MODE("job");
    
        private final String value;
    
        EmbloyRequestMode(String value) {
            this.value = value;
        }
    
        public String getValue() {
            return value;
        }
    }
}