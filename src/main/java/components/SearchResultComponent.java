package components;

import config.webdriver.DriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchResultComponent {

    Logger logger = LoggerFactory.getLogger(LoginComponent.class);
    private WebDriver driver;

    private final String RESULT_ITEM_SELECTOR = "//h2[contains(text(), '%s)]/ancestor::div[@class='s-item-container']";
    private final String RESULT_ITEM_PLATFORM_SELECTOR = "//table//h3[contains(text(), '%s')]";


    @FindBy(className = "buyingPrice")
    private WebElement purchaseItemPrice;

    @FindBy(xpath = "//a[contains(./@id, 'BESTSELLER')]/ancestor::li")
    private WebElement lnkChipestProductWithBestSeller;

    public SearchResultComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void selectProductAndPlatform(String shopItemName, String platformName) {
        WebElement shopItemContainer = driver.findElement(By.xpath(String.format(RESULT_ITEM_SELECTOR, shopItemName)));
        shopItemContainer.findElement(By.xpath(String.format(RESULT_ITEM_SELECTOR, platformName)));
        shopItemContainer.click();
    }

    public void selectPlaystation(){
        lnkChipestProductWithBestSeller.click();
    }

}
