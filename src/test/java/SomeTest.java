import components.AmazonHomeComponent;
import components.LoginComponent;
import components.NavigationSearchBarComponent;
import org.junit.jupiter.api.Test;

public class SomeTest extends TestContext{


    @Test
    void addProductToTheChart() {
        AmazonHomeComponent amazonHomeComponent = new AmazonHomeComponent();
        NavigationSearchBarComponent navigationSearchBarComponent = new NavigationSearchBarComponent();
        LoginComponent loginComponent = new LoginComponent();

        amazonHomeComponent.navigateToSignInComponent();
        loginComponent.login();
        navigationSearchBarComponent.selectCategory("Video Games");
        navigationSearchBarComponent.searchByName("playstation console 4");
        navigationSearchBarComponent.setSortingAndImageView("Price: Low to High");
        System.out.println("");
    }
}
