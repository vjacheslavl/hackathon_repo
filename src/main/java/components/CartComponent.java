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

public class CartComponent {

    Logger logger = LoggerFactory.getLogger(CartComponent.class);

    private WebDriver driver;

    @FindBy(css = "#proceedToCheckout")
    private WebElement btnProceedToCheckout;

    public CartComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    public CartComponent goToCheckout(){
        btnProceedToCheckout.click();
        return new CartComponent();
    }
}
