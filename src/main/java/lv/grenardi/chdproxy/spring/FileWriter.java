package lv.grenardi.chdproxy.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {

    private static final Logger logger = LoggerFactory.getLogger(FileWriter.class);

    // no state is used in method, can be static.
    public static void writing(String content, String filename) {
        try {
            File file = new File(filename);

            try (FileOutputStream fop = new FileOutputStream(file)) {

                // if file doesn't exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                // get the content in bytes
                byte[] contentInBytes = content.getBytes();

                fop.write(contentInBytes);
                fop.flush();
            } catch (IOException e) {
                logger.error("Error writing to a file", e);
            }
        } catch (Exception e) {
            logger.error("Error writing to a file", e);
        }
    }
}
