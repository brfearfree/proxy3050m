package lv.grenardi.chdproxy.spring;

import com.fazecast.jSerialComm.SerialPort;

import java.util.ArrayList;

public class ComDevice {
    final String descriptivePortName;
    final String systemPortName;
    final String portDescriptionPortName;

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

    /** List all registered COM devices
     * @return ArrayList of devices with system name, human friendly name and description
     */
    public static ArrayList<ComDevice> listDevices(){
        ArrayList<ComDevice> devices = new ArrayList<>();

        SerialPort[] comPorts = SerialPort.getCommPorts();

        for(int i = 0; i< comPorts.length; i++){
            devices.add(new ComDevice(comPorts[i].getDescriptivePortName(),
                    comPorts[i].getSystemPortName(),
                    comPorts[i].getPortDescription()));
        }
        return devices;
    }
}
