package components;

import config.webdriver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginComponent {

    Logger logger = LoggerFactory.getLogger(LoginComponent.class);
    private WebDriver driver;

    @FindBy(css = "[id='search_query_top']")
    private WebElement tbxLogin;

    @FindBy(css = "[name='submit_search']")
    private WebElement tbxPassword;

    public LoginComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void enterLogin() {
    }

    public void enterPassword() {
    }
}