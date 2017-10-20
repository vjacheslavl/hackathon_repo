import config.ApplicationProperties;
import config.webdriver.DriverBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import steps.LoginSteps;

import static config.ApplicationProperties.ApplicationProperty.APP_URL;

public class SomeTest {

    @BeforeAll
    public static void instantiateDriverObject() {
        DriverBase.instantiateDriverObject();
        DriverBase.getDriver().manage().window().maximize();
    }

    @AfterAll
    public static void closeDriverObjects() {
        DriverBase.closeDriverObjects();
    }

    @Test
    void test() {
        DriverBase.getDriver().get(ApplicationProperties.getString(APP_URL));
        LoginSteps loginSteps = new LoginSteps();
        System.out.println("First Tests");
    }

    @AfterEach
    public void clearCookies() throws Exception {
        DriverBase.clearCookies();
    }
}
