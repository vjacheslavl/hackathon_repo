package components;

import config.webdriver.DriverBase;
import context.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginComponent {

    Logger logger = LoggerFactory.getLogger(LoginComponent.class);
    private WebDriver driver;

    @FindBy(css = "#ap_email")
    private WebElement tbxLogin;

    @FindBy(css = "#ap_password")
    private WebElement tbxPassword;

    @FindBy(css = "#signInSubmit")
    private WebElement btnLogin;

    public LoginComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void login() {
        tbxLogin.sendKeys(TestContext.user.getEmail());
        tbxPassword.sendKeys(TestContext.user.getPassword());
        btnLogin.click();
    }
}
