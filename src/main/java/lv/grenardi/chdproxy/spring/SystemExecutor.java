package lv.grenardi.chdproxy.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// This is essentially a service.
// We should make this a service, because we can do it in Spring Boot application.
// It makes it easier to test/compose/mock etc.
@Service
public class SystemExecutor {

    private static Logger logger = LoggerFactory.getLogger(SystemExecutor.class);
    private final String path;

    public SystemExecutor(@Value("${chd3050m.path}") String path) {
        this.path = path;
    }

    /**
     * Pass macros data to SDRV.exe, which stores it on MACRO key
     *
     * @param fiscalData - macros data to be passed to SDRV.exe
     * @return - both output and error lines
     */
    public Results executeMacroCommands(String fiscalData) {
        // You probably want to construct java.nio.file.Path here, to validate that path are valid.
        // Actually, what you really want to do is use @ConfigureProperties annotation on a bean.
        // It allows type-safe externalized configuration.
        // https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config-typesafe-configuration-properties
        String commandFile = path + "ma.txt";
        String sdrvPath = path + "SDRV.exe";
        String command = sdrvPath + " send 51 " + path + "ma.txt";

        // program to an interface
        List<String> output = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        String line;
        try {
            // create command file (ma.txt)
            FileWriter.writing(fiscalData, commandFile);

            File file = new File(sdrvPath);
            if (file.exists()) {
                // execute command
                // characters are free, use them
                Process process = Runtime.getRuntime().exec(command);


                // Use try-with-resource. It will guarantee that resource will
                // be safely closed.
                // https://stackoverflow.com/questions/7860137/what-is-the-java-7-try-with-resources-bytecode-equivalent-using-try-catch-finall
                try(BufferedReader bri = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));
                    BufferedReader bre = new BufferedReader(
                            new InputStreamReader(process.getErrorStream()))) {
                    // store output
                    while ((line = bri.readLine()) != null) {
                        output.add(line);
                    }

                    // store & output errors
                    while ((line = bre.readLine()) != null) {
                        logger.info(line);
                        errors.add(line);
                    }
                }

                process.waitFor();
            } else {
                // would not be
                errors.add("SDRV.exe does not exists[" + sdrvPath + "]");
            }

        } catch (Exception exception) {
            // Note: .error method has special override, when argument is Throwable
            logger.error("Macro command execution error", exception);
            errors.add(exception.getMessage());
        }

        return new Results(output, errors);
    }
}
