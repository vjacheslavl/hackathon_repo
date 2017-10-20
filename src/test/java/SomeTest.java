import components.AmazonHomeComponent;
import org.junit.jupiter.api.Test;

public class SomeTest extends TestContext{

    @Test
    void addProductToTheChart() {
        AmazonHomeComponent amazonHomeComponent = new AmazonHomeComponent();
        amazonHomeComponent.navigateToSignInComponent();
        System.out.println("First Tests");
    }
}
