package lv.grenardi.chdproxy.spring;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SystemExecutor {

    /** Pass macros data to SDRV.exe, which stores it on MACRO key
     * @param path - local system file path to SDRV.exe executable
     * @param fiscalData - macros data to be passed to SDRV.exe
     * @return - both output and error lines
     */
    public static Results ExecuteMacroCommands(String path, String fiscalData) {

        String commandFile = path + "ma.txt";
        String sdrvPath = path + "SDRV.exe";
        String command = sdrvPath + " send 51 " + path + "ma.txt";

        ArrayList<String> output = new ArrayList<>();
        ArrayList<String> errors = new ArrayList<>();

        String line;
        try {
            // create command file (ma.txt)
            FileWriter fileWriter = new FileWriter();
            fileWriter.writing(fiscalData, commandFile);

            File file = new File(sdrvPath);
            if(file.exists()) {
                // execute command
                Process p = Runtime.getRuntime().exec(command);

                // store output
                BufferedReader bri = new BufferedReader
                        (new InputStreamReader(p.getInputStream()));
                BufferedReader bre = new BufferedReader
                        (new InputStreamReader(p.getErrorStream()));

                while ((line = bri.readLine()) != null) {
                    output.add(line);
                }
                bri.close();

                // store & output errors
                while ((line = bre.readLine()) != null) {
                    System.out.println(line);
                    errors.add(line);
                }
                bre.close();
                p.waitFor();
            }
            else{
                errors.add("SDRV.exe does not exists[" + sdrvPath + "]");
            }

        } catch (Exception err) {
            err.printStackTrace();
            errors.add(err.getMessage());
        }

        return new Results(output, errors);
    }
}
