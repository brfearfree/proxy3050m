package lv.grenardi.chdproxy.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class PostConstructBean {
    @Value("${chd3050m.path}")
    public String path;

    @PostConstruct
    public void init() {
        Tray.initialize(path);
    }
}
