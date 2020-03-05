package lv.grenardi.chdproxy.spring;

// If you would upgrade to Java 14, then you could use Records.
// https://openjdk.java.net/jeps/359
public class PrintResult {
    // Don't forget visibility modifiers
    private final Integer dealId;
    private final Integer userId;
    private final String incomingData;
    private final Results results;

    public PrintResult(Integer dealId, Integer userId, String incomingData, Results results) {
        this.dealId = dealId;
        this.userId = userId;
        this.incomingData = incomingData;
        this.results = results;
    }

    public Integer getDealId() {
        return dealId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getIncomingData() {
        return incomingData;
    }

    public Results getResults() {
        return results;
    }
}
