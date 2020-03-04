package lv.grenardi.chdproxy.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrintReceiptController {

    // Declaring fields as final shows an intention: reference will never be modified.
    // It's thead safe to read such reference.
    // Also it might help JIT with optimizations (but I am not sure about this one, too lazy to find references).
    private final SystemExecutor systemExecutor;

    // Everything that can be injected into controller, should be injected in controller.
    // In your case @Value is a static configuration value. So, should be lifted into constructor.
    public PrintReceiptController(SystemExecutor systemExecutor) {
        this.systemExecutor = systemExecutor;
    }

    @PostMapping("/3050m/printReceipt")
    public PrintResult print3050mReceipt(
            @RequestParam(value = "dealId", defaultValue = "0") Integer dealId,
            @RequestParam(value = "userId", defaultValue = "0") Integer userId,
            @RequestParam(value = "data", defaultValue = "") String data
    ) {
        return new PrintResult(
                dealId,
                userId,
                data,
                this.systemExecutor.executeMacroCommands(data)
        );
    }
}
