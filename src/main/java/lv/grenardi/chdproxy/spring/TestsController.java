package lv.grenardi.chdproxy.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

@RestController

public class TestsController {
    @GetMapping("/3050m/test")
    public Chd3050mTestResults test3050m(@Value("${chd3050m.path}") String path,
                                         @Value("${chd3050m.Device3050mTestData}") String Device3050mTestData,
                                         @Value("${chd3050m.Device3050mName}") String Device3050mName) {
        // mock data
        Integer userId = 1;
        Integer dealId = 10;

        System.err.println("----------------");
        System.err.println(path);
        System.err.println(Device3050mTestData);
        System.err.println(Device3050mName);
        System.err.println("----------------");

        // try executing (will fail due to data)
        PrintResult printResult = new PrintResult(dealId, userId, Device3050mTestData,
                SystemExecutor.ExecuteMacroCommands(path, Device3050mTestData));

        // check if file was saved properly
        boolean isWriteOk = false;
        try{
            File file = new File(path + "ma.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            if(((st = br.readLine()) != null) && st.equals(Device3050mTestData)){
                isWriteOk = true;
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // check if device is on
        boolean isDeviceOnline = false;
        ArrayList<ComDevice> comDevices = ComDevice.listDevices();
        if(comDevices.size() > 0){
            for (ComDevice comDevice : comDevices) {
                if (comDevice.descriptivePortName.contains(Device3050mName)) {
                    isDeviceOnline = true;
                }
            }
        }

        return new Chd3050mTestResults(printResult, isWriteOk, isDeviceOnline);
    }
}
