package lv.grenardi.chdproxy.spring;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chd3050m {
    public static String getConfiguredPortName(String path){
        String portName = "";

        try {
            String fileName = path + "SDRV.ini";
            Scanner fileScanner = new Scanner(new File(fileName));
            Pattern pattern = Pattern.compile("ComNumber = (\\d)");
            Matcher matcher = null;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    portName = matcher.group(1);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return portName;
    }
}
