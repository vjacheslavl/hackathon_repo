package components;
/*
 * Copyright C.T.Co Ltd, 15/25 Jurkalnes Street, Riga LV-1046, Latvia. All rights reserved.
 */

import config.webdriver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import support.web.WebElementHelper;

public class ItemComponent {

    Logger logger = LoggerFactory.getLogger(ItemComponent.class);
    private WebDriver driver;
    private Actions actions;

    @FindBy(css = "#add-to-cart-button")
    private WebElement btnAddToCart;

    @FindBy(css = "#nav-cart-count")
    private WebElement btnMoveToCart;

    @FindBy(className = "buyingPrice")
    private WebElement purchaseItemPrice;

    public ItemComponent() {
        this.driver = DriverBase.getDriver();
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public ItemComponent addToCart(){
        btnAddToCart.click();
        return new ItemComponent();
    }

    public CartComponent navigateToCart() {
        btnMoveToCart.click();
        return new CartComponent();
    }

    public boolean isDisplayed() {
        return WebElementHelper.isElementDisplayed(btnAddToCart);
    }
}
