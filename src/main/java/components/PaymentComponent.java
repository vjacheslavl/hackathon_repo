package components;

import config.webdriver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentComponent {

    Logger logger = LoggerFactory.getLogger(PaymentComponent.class);
    private WebDriver driver;

    @FindBy(xpath = "//*[.='Add a Payment Method']")
    public WebElement lblAddAPaymentMethod;

    public PaymentComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }



}
