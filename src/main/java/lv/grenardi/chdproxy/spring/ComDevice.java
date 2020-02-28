package lv.grenardi.chdproxy.spring;

public class ComDevice {
    String descriptivePortName;
    String systemPortName;
    String portDescriptionPortName;

    public ComDevice(String descriptivePortName, String systemPortName, String portDescriptionPortName) {
        this.descriptivePortName = descriptivePortName;
        this.systemPortName = systemPortName;
        this.portDescriptionPortName = portDescriptionPortName;
    }

    public String getDescriptivePortName() {
        return descriptivePortName;
    }

    public void setDescriptivePortName(String descriptivePortName) {
        this.descriptivePortName = descriptivePortName;
    }

    public String getSystemPortName() {
        return systemPortName;
    }

    public void setSystemPortName(String systemPortName) {
        this.systemPortName = systemPortName;
    }

    public String getPortDescriptionPortName() {
        return portDescriptionPortName;
    }

    public void setPortDescriptionPortName(String portDescriptionPortName) {
        this.portDescriptionPortName = portDescriptionPortName;
    }
}
