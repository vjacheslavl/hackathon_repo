package steps;

import components.CartComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class ShoppingCartSteps {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartSteps.class);
    CartComponent cartComponent = new CartComponent();


    public ShoppingCartSteps thenShoppingCartDisplayed() {
        logger.info("Checking that shopping cart is displayed");
        assertThat(cartComponent.isDisplayed()).isTrue().as("Shopping cart is not displayed");
        return this;
    }

    public ShoppingCartSteps whenUserProceedsToCheckout() {
        logger.info("Proceed to checkout");
        cartComponent.goToCheckout();
        return this;
    }
}