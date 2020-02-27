package lv.grenardi.chdproxy.spring;

public class Greeting {

    private final String content;
    private final Number version = 0.1;

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Number getVersion() {
        return version;
    }
}
