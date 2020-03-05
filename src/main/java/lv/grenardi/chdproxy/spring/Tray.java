package lv.grenardi.chdproxy.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.*;

@Component
public class Tray {

    private static final Logger logger = LoggerFactory.getLogger(Tray.class);

    private final String path;

    // It is important to use constructor injection.
    // Because in this way we can make fields final and Spring does not need
    // to use reflection to inject there.
    public Tray(@Value("${chd3050m.path}") String path) {
        this.path = path;
    }

    @PostConstruct
    public void init() {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            // Where is this image?
            Image image = Toolkit.getDefaultToolkit().getImage(this.path + "icon16.png");
            PopupMenu popup = new PopupMenu();

            MenuItem closeItem = new MenuItem("Exit");
            closeItem.addActionListener(e -> System.exit(0));

            popup.add(closeItem);

            TrayIcon trayIcon = new TrayIcon(image, "GMS - CHD3050m", popup);
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                logger.error("Error adding tray icon", e);
            }
        } else {
            logger.warn("Tray unavailable");
        }
    }
}
