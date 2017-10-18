import config.ApplicationProperties;
import config.webdriver.DriverBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        System.out.println("TEST");
    }

    @Test
    void test2() {
        System.out.println("TEST");
    }

    @AfterEach
    public void clearCookies() throws Exception {
        DriverBase.clearCookies();
    }
}
