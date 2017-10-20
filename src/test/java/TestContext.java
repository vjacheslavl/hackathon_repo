import config.ApplicationProperties;
import config.webdriver.DriverBase;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import java.util.concurrent.TimeUnit;
import static config.ApplicationProperties.ApplicationProperty.APP_URL;
import static config.ApplicationProperties.ApplicationProperty.WAIT_TIMEOUT_SHT;
import io.qameta.allure.junit5.AllureJunit5AnnotationProcessor;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureJunit5AnnotationProcessor.class)

public class TestContext {

    @BeforeAll
    public static void instantiateDriverObject() {
        DriverBase.instantiateDriverObject();
        DriverBase.getDriver().manage().window().maximize();
        DriverBase.getDriver().get(ApplicationProperties.getString(APP_URL));
        DriverBase.getDriver().manage().timeouts().implicitlyWait(ApplicationProperties.getInteger(WAIT_TIMEOUT_SHT), TimeUnit.MILLISECONDS);
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
