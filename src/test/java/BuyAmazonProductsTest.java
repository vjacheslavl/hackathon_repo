import context.TestContext;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

@Feature("Buy products")
public class BuyAmazonProductsTest extends TestContext {


    @Test
    @Story("Playstation 4")
    void buyPlaystation4() {


        startTest()
                .givenUserLoggedIn()
                .whenUserSearchesFor("Playstation 4")
                .whenUserSetsSorting("Price: Low to High")
                .whenUserSelectedSpecificCategory("Consoles")
                .whenUserSelectedShipsToCountry()
                .thenSearchResultDisplayed()
                .whenUserSelectedBestSellerProduct()
                .thenProductScreenDisplayed()
                .whenUserAddsProductToCart()
                .thenShoppingCartDisplayed()
                .whenUserProceedsToCheckout()
                .deliverToThisAddress()
                .clickContinue()
                .thenPaymentIsDispalyed();

    }

    @Test
    @Story("Playstation Camera")
    void buyCamera() {

        startTest()
                .givenUserLoggedIn()
                .whenUserSearchesFor("playstation cam")
                .whenUserSelectedShipsToCountry()

                .thenSearchResultDisplayed()

                .whenUserSelectedBestSellerProduct()

                .thenProductScreenDisplayed()

                .whenUserAddsProductToCart()

                .thenShoppingCartDisplayed();
    }
}
