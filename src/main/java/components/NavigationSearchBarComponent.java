package components;

import config.webdriver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NavigationSearchBarComponent {

    Logger logger = LoggerFactory.getLogger(LoginComponent.class);
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='nav-search-field ']/input")
    private WebElement searchBarInput;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']/input")
    private WebElement goSearchButton;

    public NavigationSearchBarComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void searchByName(String name) {
        searchBarInput.sendKeys(name);
        goSearchButton.click();
    }


}
