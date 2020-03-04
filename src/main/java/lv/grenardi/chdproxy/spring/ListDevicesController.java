package lv.grenardi.chdproxy.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListDevicesController {

    @GetMapping("/utility/list-com-devices")
    public List<ComDevice> ListDevices() {
        return ComDevices.list();
    }
}
