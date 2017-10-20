import config.ApplicationProperties;
import config.webdriver.DriverBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static config.ApplicationProperties.ApplicationProperty.APP_URL;

public class TestContext {

    @BeforeAll
    public static void instantiateDriverObject() {
        DriverBase.instantiateDriverObject();
        DriverBase.getDriver().manage().window().maximize();
        DriverBase.getDriver().get(ApplicationProperties.getString(APP_URL));
    }

    @AfterAll
    public static void closeDriverObjects() {
        DriverBase.closeDriverObjects();
    }

    @AfterEach
    public void clearCookies() throws Exception {
        DriverBase.clearCookies();
    }
}
