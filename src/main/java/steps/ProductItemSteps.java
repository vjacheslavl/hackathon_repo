package steps;

import components.ItemComponent;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductItemSteps {
    private static final Logger logger = LoggerFactory.getLogger(ProductItemSteps.class);
    ItemComponent itemComponent = new ItemComponent();


    @Step
    public ProductItemSteps thenProductScreenDisplayed() {
        logger.info("Checking that Product Screen displayed");
        assertThat(itemComponent.isDisplayed()).isTrue().as("Product screen is not displayed");
        return this;
    }

    public ShoppingCartSteps whenUserAddsProductToCart() {
        logger.info("Adding product to cart");
        itemComponent.addToCart();
        logger.info("Navigating to cart");
        itemComponent.navigateToCart();
        return new ShoppingCartSteps();
    }
}
