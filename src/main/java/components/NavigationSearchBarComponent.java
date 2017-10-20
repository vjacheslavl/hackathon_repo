package components;

import config.webdriver.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static support.web.WebElementHelper.*;

public class NavigationSearchBarComponent {

    Logger logger = LoggerFactory.getLogger(NavigationSearchBarComponent.class);
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='nav-search-field ']/input")
    private WebElement txtSearchBar;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']/input")
    private WebElement btnGoSearch;

    @FindBy(css = "#sort")
    private WebElement cmbSortBy;

    @FindBy(css = "#searchDropdownBox")
    private WebElement cmbCategory;

    @FindBy(xpath = "//form[@id='searchSortForm']/following-sibling::span[2]")
    private WebElement btnImageView;

    public NavigationSearchBarComponent() {
        this.driver = DriverBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void selectCategory(String value){
        selectByVisiableText(cmbCategory, value);
    }

    public void searchByName(String name) {
        txtSearchBar.sendKeys(name);
        btnGoSearch.click();
    }


    public void setSortingAndImageView(String value){
        selectByVisiableText(cmbSortBy, value);
        click(btnImageView);
    }
}
