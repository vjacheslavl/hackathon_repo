import org.junit.jupiter.api.Test;


public class SomeTest extends TestContext {


    @Test
    void addProductToTheChart() {

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

                .whenUserProceedsToCheckout();
    }
}
