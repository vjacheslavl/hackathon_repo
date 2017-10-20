package steps;

import components.AmazonHomeComponent;
import components.LoginComponent;
import config.webdriver.DriverFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

    public SearchSteps givenUserLoggedIn() {
        logger.info("logging in");
        AmazonHomeComponent amazonHomeComponent = new AmazonHomeComponent();
        LoginComponent loginComponent = new LoginComponent();

        amazonHomeComponent.navigateToSignInComponent();
        loginComponent.login();
        return new SearchSteps();
    }
}
