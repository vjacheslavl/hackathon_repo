package components;

import config.webdriver.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeftNavigationBarComponent {

    Logger logger = LoggerFactory.getLogger(LoginComponent.class);
    private WebDriver driver;

    private final String ITEM_CATEGORY_LOCATOR = "//div[contains(@id, 'leftNav')]//span[contains(text(), '%s')]";
    private final String SHIPPING_COUNTRY_LOCATOR = "//div[contains(@id, 'leftNav')]//span[contains(text(), 'Ship to %s')]";

    @FindBy(xpath = "//span[text()='4 Stars & Up']")
    private WebElement btnFourStars;

    public LeftNavigationBarComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    public LeftNavigationBarComponent searchByCategory(String categoryName) {
        WebElement category = driver.findElement(By.xpath(String.format(ITEM_CATEGORY_LOCATOR, categoryName)));
        category.click();
        return new LeftNavigationBarComponent();
    }

    public LeftNavigationBarComponent selectShipByCountry(String countryName) {
        WebElement category = driver.findElement(By.xpath(String.format(SHIPPING_COUNTRY_LOCATOR, countryName)));
        category.click();
        return new LeftNavigationBarComponent();
    }

    public LeftNavigationBarComponent select4StarsCustomer() {
        btnFourStars.click();
        return this;
    }

}
