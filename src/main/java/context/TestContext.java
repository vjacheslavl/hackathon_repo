package context;

import config.ApplicationProperties;
import config.webdriver.DriverBase;
import dataobjects.TestUser;
import io.qameta.allure.junit5.AllureJunit5AnnotationProcessor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import providers.DistributedTestUsersProvider;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

import static config.ApplicationProperties.ApplicationProperty.APP_URL;
import static config.ApplicationProperties.ApplicationProperty.WAIT_TIMEOUT_SHT;

@ExtendWith(AllureJunit5AnnotationProcessor.class)

public class TestContext {

    public static TestUser user;

    @BeforeAll
    public static void instantiateDriverObject() {
        DistributedTestUsersProvider testUsersProvider = DistributedTestUsersProvider.getInstance();
        user = testUsersProvider.take();
        DriverBase.instantiateDriverObject();
        DriverBase.getDriver().manage().window().maximize();
    }

    protected LoginSteps startTest() {
        DriverBase.getDriver().get(ApplicationProperties.getString(APP_URL));
        DriverBase.getDriver().manage().timeouts().implicitlyWait(ApplicationProperties.getInteger(WAIT_TIMEOUT_SHT), TimeUnit.MILLISECONDS);
        return new LoginSteps();
    }

    @AfterAll
    public static void closeDriverObjects() {
        DistributedTestUsersProvider.getInstance().release(user);
        DriverBase.closeDriverObjects();
    }

    @AfterEach
    public void clearCookies() throws Exception {
        DriverBase.clearCookies();
    }
}
