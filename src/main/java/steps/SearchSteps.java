package steps;

import components.LeftNavigationBarComponent;
import components.NavigationSearchBarComponent;
import components.SearchResultComponent;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class SearchSteps {
    private static final Logger logger = LoggerFactory.getLogger(SearchSteps.class);
    NavigationSearchBarComponent navigationSearchBarComponent = new NavigationSearchBarComponent();
    LeftNavigationBarComponent leftNavigationBarComponent = new LeftNavigationBarComponent();
    SearchResultComponent searchResultComponent = new SearchResultComponent();

    @Step
    public SearchSteps whenUserSelectedCategory(String category) {
        logger.info(String.format("Category selected - %s", category));
        navigationSearchBarComponent.selectCategory(category);
        return this;
    }

    @Step
    public SearchSteps whenUserSearchesFor(String searchName) {
        logger.info(String.format("Search criteria - %s", searchName));
        navigationSearchBarComponent.searchByName(searchName);
        return this;
    }

    @Step
    public SearchSteps whenUserSetsSorting(String searchName) {
        logger.info(String.format("Sorting selected - %s", searchName));
        navigationSearchBarComponent.setSortingAndImageView(searchName);
        return this;
    }

    @Step
    public SearchSteps whenUserSelectedSpecificCategory(String category) {
        logger.info(String.format("Specific category selected - %s", category));
        leftNavigationBarComponent.searchByCategory(category);
        return this;
    }

    @Step
    public SearchSteps whenUserSelectedShipsToCountry() {
        logger.info("Shipping country selected");
        leftNavigationBarComponent.selectShipByCountry();
        return this;
    }

    @Step
    public SearchSteps thenSearchResultDisplayed() {
        logger.info("Checking Search Result display");
        assertThat(searchResultComponent.isDisplayed()).isTrue().as("Search results are not displayed");
        return this;
    }

    @Step
    public ProductItemSteps whenUserSelectedBestSellerProduct() {
        searchResultComponent.selectPlaystation();
        return new ProductItemSteps();
    }

}
