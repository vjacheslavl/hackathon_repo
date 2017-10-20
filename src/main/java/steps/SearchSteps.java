package steps;

import components.NavigationSearchBarComponent;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchSteps {
    private static final Logger logger = LoggerFactory.getLogger(SearchSteps.class);
    NavigationSearchBarComponent navigationSearchBarComponent = new NavigationSearchBarComponent();

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

}
