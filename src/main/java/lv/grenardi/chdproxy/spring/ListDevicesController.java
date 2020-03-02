package lv.grenardi.chdproxy.spring;

import com.fazecast.jSerialComm.SerialPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ListDevicesController {

    @GetMapping("/utility/list-com-devices")
    public ArrayList<ComDevice> ListDevices(){
        return ComDevice.listDevices();
    }

}
