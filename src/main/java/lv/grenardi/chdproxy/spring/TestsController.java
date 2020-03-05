package lv.grenardi.chdproxy.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@RestController

public class TestsController {

    private static final Logger logger = LoggerFactory.getLogger(TestsController.class);

    private final String path;
    private final String device3050mTestData;
    private final String device3050mName;
    private final SystemExecutor systemExecutor;

    public TestsController(
            @Value("${chd3050m.path}") String path,
            @Value("${chd3050m.Device3050mTestData}") String Device3050mTestData,
            @Value("${chd3050m.Device3050mName}") String Device3050mName,
            SystemExecutor systemExecutor
    ) {
        this.path = path;
        this.device3050mTestData = Device3050mTestData;
        this.device3050mName = Device3050mName;
        this.systemExecutor = systemExecutor;
    }

    @GetMapping("/3050m/test")
    public Chd3050mTestResults test3050m() {
        // mock data
        Integer userId = 1;
        Integer dealId = 10;

        // delete command file if any
        File oldFile = new File(path + "ma.txt");
        if(oldFile.exists()){
            oldFile.delete();
        }

        // try executing (will fail due to data)
        PrintResult printResult = new PrintResult(
                dealId,
                userId,
                this.device3050mTestData,
                this.systemExecutor.executeMacroCommands(this.device3050mTestData)
        );

        // check if file was saved properly
        boolean isWriteOk = false;
        File file = new File(path + "ma.txt");
        // resource should be closed when finished with it
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st;
            if (((st = br.readLine()) != null) && st.equals(this.device3050mTestData)) {
                isWriteOk = true;
            }
        } catch (Exception e) {
            logger.error("Error", e);
        }

        // It's more elegant, if using streams syntax.
        boolean isDeviceOnline = ComDevices.list()
                .stream()
                .filter(comDevice -> comDevice.getDescriptivePortName().contains(this.device3050mName))
                .findAny()
                .isPresent();


        boolean isDeviceConfigured = false;
        String configuredPortName = "";

        /*
        // Check if SDRV.ini properly configured
        if(!portName.equals("")){
            configuredPortName = Chd3050m.getConfiguredPortName(path);

            if(portName.equals("COM" + configuredPortName)){
                isDeviceConfigured = true;
            }
        }*/

        return new Chd3050mTestResults(printResult, isWriteOk, isDeviceOnline, isDeviceConfigured, configuredPortName);
    }
}
