package lv.grenardi.chdproxy.spring;

public class PrintResult {
    final Integer dealId;
    final Integer userId;
    final String incomingData;
    final Results results;

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
