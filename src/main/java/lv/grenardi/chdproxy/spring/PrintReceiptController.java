package lv.grenardi.chdproxy.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrintReceiptController {
    @PostMapping("/3050m/printReceipt")
    public PrintResult print3050mReceipt(@RequestParam(value = "dealId", defaultValue = "0") Integer dealId,
                                         @RequestParam(value = "userId", defaultValue = "0") Integer userId,
                                         @RequestParam(value = "data", defaultValue = "") String data,
                                         @Value("${chd3050m.path}") String path) {

        PrintResult printResult = new PrintResult(dealId, userId, data,
                SystemExecutor.ExecuteMacroCommands(path, data));

        return printResult;
    }
}
