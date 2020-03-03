package lv.grenardi.chdproxy.spring;

public class Chd3050mTestResults {
    final PrintResult printResult;
    final boolean isWriteOk;
    final boolean isDeviceOnline;
    final boolean isDeviceConfigured;
    final String configuredPortName;

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
