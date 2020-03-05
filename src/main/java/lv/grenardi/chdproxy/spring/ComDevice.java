package lv.grenardi.chdproxy.spring;

public class ComDevice {
    private final String descriptivePortName;
    private final String systemPortName;
    private final String portDescriptionPortName;

    public ComDevice(String descriptivePortName, String systemPortName, String portDescriptionPortName) {
        this.descriptivePortName = descriptivePortName;
        this.systemPortName = systemPortName;
        this.portDescriptionPortName = portDescriptionPortName;
    }

    public String getDescriptivePortName() {
        return descriptivePortName;
    }

    public String getSystemPortName() {
        return systemPortName;
    }

    public String getPortDescriptionPortName() {
        return portDescriptionPortName;
    }
}
