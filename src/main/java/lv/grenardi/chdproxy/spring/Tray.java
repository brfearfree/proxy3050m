package lv.grenardi.chdproxy.spring;

import java.awt.*;

public class Tray {
    public static void initialize(String path){

        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage(path + "icon16.png");
            PopupMenu popup = new PopupMenu();

            MenuItem closeItem = new MenuItem("Exit");
            closeItem.addActionListener(e -> System.exit(0));

            popup.add(closeItem);

            TrayIcon trayIcon = new TrayIcon(image, "GMS - CHD3050m", popup);
            try {
                tray.add(trayIcon);
            }
            catch (AWTException e) {
                System.err.println("Can't add to tray");
            }
        } else {
            System.err.println("Tray unavailable");
        }
    }
}
