package lv.grenardi.chdproxy.spring;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {
    public void writing(String content, String filename) {
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
                fop.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
