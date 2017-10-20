import context.TestContext;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Buy games")
public class BuyAmazonGameTest extends TestContext {

    @Test
    @Story("just dance 2018")
    @DisplayName("Game buy test")
    void buyPlaystation4() {

        startTest()
                .givenUserLoggedIn()
                .whenUserSearchesFor("just dance 2018")
                .whenUserSelectsProductAndPlatform("Just Dance 2018", "PlayStation 4")
                .thenShoppingCartDisplayed();
    }
}
