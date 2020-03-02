package lv.grenardi.chdproxy.spring;

import java.util.ArrayList;

public class Results {
    public final ArrayList<String> output;
    public final ArrayList<String> errors;

    public Results(ArrayList<String> output, ArrayList<String> errors) {
        this.output = output;
        this.errors = errors;
    }
}
