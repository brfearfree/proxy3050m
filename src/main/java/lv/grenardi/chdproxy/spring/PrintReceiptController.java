package lv.grenardi.chdproxy.spring;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrintReceiptController {
    @PostMapping("/printReceipt")
    public PrintResult greeting(@RequestParam(value = "dealId", defaultValue = "0") Integer dealId,
                             @RequestParam(value = "userId", defaultValue = "0") Integer userId,
                             @RequestParam(value = "data", defaultValue = "") String data) {
        PrintResult printResult = new PrintResult(dealId, userId, data);



        return printResult;
    }
}
