package steps;

import components.LeftNavigationBarComponent;
import components.NavigationSearchBarComponent;
import components.PaymentComponent;
import components.SearchResultComponent;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import support.web.WebElementHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentStep {

    private static final Logger logger = LoggerFactory.getLogger(PaymentStep.class);
    PaymentComponent paymentComponent = new PaymentComponent();


    @Step
    public PaymentStep thenPaymentIsDispalyed() {
        logger.info("Checking Search Result display");
        return this;
    }
}
