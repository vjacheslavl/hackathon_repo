import org.junit.jupiter.api.Test;


public class SomeTest extends TestContext {


    @Test
    void addProductToTheChart() {

        startTest()
                .givenUserLoggedIn()
                .whenUserSelectedCategory("Video Games")
                .whenUserSearchesFor("playstation console 4")
                .whenUserSetsSorting("Price: Low to High");
    }
}
