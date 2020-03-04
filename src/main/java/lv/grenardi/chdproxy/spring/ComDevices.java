package lv.grenardi.chdproxy.spring;

import com.fazecast.jSerialComm.SerialPort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Do not mix data classes and services.
public class ComDevices {

    /**
     * List all registered COM devices
     *
     * @return ArrayList of devices with system name, human friendly name and description
     */
    public static List<ComDevice> list() {
        //List<ComDevice> devices = new ArrayList<>();
        //SerialPort[] comPorts = SerialPort.getCommPorts();
        //for(int i = 0; i< comPorts.length; i++){
        //    devices.add(new ComDevice(comPorts[i].getDescriptivePortName(),
        //            comPorts[i].getSystemPortName(),
        //            comPorts[i].getPortDescription()));
        //}
        return Arrays
                .stream(SerialPort.getCommPorts())
                .map(comPort -> new ComDevice(
                        comPort.getDescriptivePortName(),
                        comPort.getSystemPortName(),
                        comPort.getPortDescription()
                ))
                .collect(Collectors.toList());
    }
}
