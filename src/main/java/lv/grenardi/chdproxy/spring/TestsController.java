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

        // delete command file if any
        File oldFile = new File(path + "ma.txt");
        if(oldFile.exists()){
            oldFile.delete();
        }

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
            br.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        // check if device is on
        boolean isDeviceOnline = false;
        String portName = "";
        ArrayList<ComDevice> comDevices = ComDevice.listDevices();
        if(comDevices.size() > 0){
            for (ComDevice comDevice : comDevices) {
                if (comDevice.portDescriptionPortName.equals(Device3050mName)) {
                    isDeviceOnline = true;
                    portName = comDevice.systemPortName;
                }
            }
        }

        boolean isDeviceConfigured = false;
        String configuredPortName = "";
        // Check if SDRV.ini properly configured
        if(!portName.equals("")){
            configuredPortName = Chd3050m.getConfiguredPortName(path);

            if(portName.equals("COM" + configuredPortName)){
                isDeviceConfigured = true;
            }
        }

        return new Chd3050mTestResults(printResult, isWriteOk, isDeviceOnline, isDeviceConfigured, configuredPortName);
    }
}
