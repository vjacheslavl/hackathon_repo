package steps;

import components.CartComponent;
import components.CheckoutComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class ShoppingCartSteps {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartSteps.class);

    CartComponent cartComponent = new CartComponent();


    public ProductItemSteps thenShoppingCartDisplayed() {
        logger.info("Checking that shopping cart is displayed");
        assertThat(cartComponent.isDisplayed()).isTrue().as("Shopping cart is not displayed");
        return new ProductItemSteps();
    }

    public CheckoutComponent whenUserProceedsToCheckout() {
        logger.info("Proceed to checkout");
        cartComponent.goToCheckout();
        return new CheckoutComponent();
    }
}