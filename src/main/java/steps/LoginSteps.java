package steps;

import components.LoginComponent;

public class LoginSteps {
    LoginComponent login;

    public void login() {
        LoginComponent login = new LoginComponent();
        login.enterLogin();
        login.enterPassword();
    }
}