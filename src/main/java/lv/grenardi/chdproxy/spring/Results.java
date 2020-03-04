package lv.grenardi.chdproxy.spring;

import java.util.List;

public class Results {
    // Program to an interface.
    // https://stackoverflow.com/questions/383947/what-does-it-mean-to-program-to-an-interface
    private final List<String> output;
    private final List<String> errors;

    public Results(List<String> output, List<String> errors) {
        this.output = output;
        this.errors = errors;
    }

    public List<String> getOutput() {
        return output;
    }

    public List<String> getErrors() {
        return errors;
    }
}
