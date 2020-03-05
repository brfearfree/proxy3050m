package lv.grenardi.chdproxy.spring;

public class Chd3050mTestResults {
    private final PrintResult printResult;
    private final boolean isWriteOk;
    private final boolean isDeviceOnline;
    private final boolean isDeviceConfigured;
    private final String configuredPortName;

    public Chd3050mTestResults(PrintResult printResult, boolean isWriteOk, boolean isDeviceOnline, boolean isDeviceConfigured, String configuredPortName) {
            this.printResult = printResult;
            this.isWriteOk = isWriteOk;
            this.isDeviceOnline = isDeviceOnline;
            this.isDeviceConfigured = isDeviceConfigured;
            this.configuredPortName = configuredPortName;
        }

    public PrintResult getPrintResult() {
        return printResult;
    }

    public boolean isWriteOk() {
        return isWriteOk;
    }

    public boolean isDeviceOnline() {
        return isDeviceOnline;
    }

    public boolean isDeviceConfigured() {
        return isDeviceConfigured;
    }

    public String getConfiguredPortName() {
        return configuredPortName;
    }
}
