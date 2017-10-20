package components;

import config.webdriver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchResultComponent {

    Logger logger = LoggerFactory.getLogger(LoginComponent.class);
    private WebDriver driver;

    private final String RESULTS_PLATFORM_SELECTOR =
        "//h2[contains(text(), 'Just Dance 2018')]/ancestor::div[@class='s-item-container']//table//h3[contains(text(), 'PlayStation 4')]";

    public SearchResultComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }


}
