package components;

import config.webdriver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmazonHomeComponent {

    Logger logger = LoggerFactory.getLogger(AmazonHomeComponent.class);
    private WebDriver driver;
    private Actions actions;

    @FindBy(css = "#nav-link-accountList")
    private WebElement lnkHelloSignIn;

    @FindBy(css = "#nav-signin-tooltip span")
    private WebElement btnSignIn;

    public AmazonHomeComponent() {
        this.driver = DriverBase.getDriver();
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginComponent navigateToSignInComponent(){
        actions.moveToElement(lnkHelloSignIn);
        btnSignIn.click();
        return new LoginComponent();
    }
}
