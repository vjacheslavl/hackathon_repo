import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Feature("Buy games")
public class BuyAmazonGameTest extends TestContext {

    @Test
    @Story("just dance 2018")
    void buyPlaystation4() {

        startTest()
                .givenUserLoggedIn()
                .whenUserSearchesFor("just dance 2018")
                .whenUserSelectsProductAndPlatform("Just Dance 2018", "PlayStation 4")
                .thenShoppingCartDisplayed()
                .whenUserAddsProductToCart();
    }
}