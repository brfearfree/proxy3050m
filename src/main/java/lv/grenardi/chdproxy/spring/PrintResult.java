package lv.grenardi.chdproxy.spring;

public class PrintResult {
    String reply = "";
    String code = "";
    String resultingData = "";

    Integer dealId;
    Integer userId;
    String incomingData;

    public PrintResult(Integer dealId, Integer userId, String incomingData) {
        this.dealId = dealId;
        this.userId = userId;
        this.incomingData = incomingData;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getResultingData() {
        return resultingData;
    }

    public void setResultingData(String resultingData) {
        this.resultingData = resultingData;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIncomingData() {
        return incomingData;
    }

    public void setIncomingData(String incomingData) {
        this.incomingData = incomingData;
    }
}
