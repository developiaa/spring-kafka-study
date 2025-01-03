package study.developia.checkout;

import ch.qos.logback.core.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class CheckOutFormController {

    @GetMapping("checkoutForm")
    public String checkoutForm(Model model) {
        log.info("checkoutForm..");
        return "checkOutForm";
    }
}
