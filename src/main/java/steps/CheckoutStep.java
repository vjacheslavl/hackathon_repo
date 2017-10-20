package steps;

import components.CartComponent;
import components.CheckoutComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutStep {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutStep.class);

    CheckoutComponent checkoutComponent = new CheckoutComponent();

    public CheckoutComponent whenUserProceedsToCheckout() {
        logger.info("Proceed to checkout");
        checkoutComponent.deliverToThisAddress();
        checkoutComponent.clickContinue();
        return new CheckoutComponent();
    }
}
