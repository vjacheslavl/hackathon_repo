package components;

import config.webdriver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import steps.PaymentStep;

public class CheckoutComponent {

    Logger logger = LoggerFactory.getLogger(CheckoutComponent.class);

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(.,'Deliver to this address')]")
    private WebElement btnDeliverToThisAddress;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement btnContinue;


    public CheckoutComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    public CheckoutComponent deliverToThisAddress(){
        btnDeliverToThisAddress.click();
        return this;
    }

    public PaymentStep clickContinue(){
        btnContinue.click();
        return new PaymentStep();
    }
}
