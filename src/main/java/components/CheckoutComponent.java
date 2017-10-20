package components;

import config.webdriver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutComponent {

    Logger logger = LoggerFactory.getLogger(CheckoutComponent.class);

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(.,'Deliver to this address')]")
    private WebElement btnDeliverToThisAddress;

    @FindBy(xpath = "//input[contains(.,'Continue')]")
    private WebElement btnContinue;


    public CheckoutComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void deliverToThisAddress(){
        btnDeliverToThisAddress.click();
    }

    public void clickContinue(){
        btnContinue.click();
    }
}
