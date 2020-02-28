package lv.grenardi.chdproxy.spring;

import com.fazecast.jSerialComm.SerialPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ListDevicesController {

    @GetMapping("/utility/list-com-devices")
    public ArrayList<ComDevice> ListDevices(){
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
