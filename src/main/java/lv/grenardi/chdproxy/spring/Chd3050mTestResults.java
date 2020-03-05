package lv.grenardi.chdproxy.spring;

public class Chd3050mTestResults {
    private final PrintResult printResult;
    private final boolean isWriteOk;
    private final boolean isDeviceOnline;

    public Chd3050mTestResults(PrintResult printResult, boolean isWriteOk, boolean isDeviceOnline) {
        this.printResult = printResult;
        this.isWriteOk = isWriteOk;
        this.isDeviceOnline = isDeviceOnline;
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
}
