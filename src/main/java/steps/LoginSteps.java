package steps;

import components.LoginComponent;

public class LoginSteps {

    LoginComponent login = new LoginComponent();

    public void login() {
        login.getBtnLogin().sendKeys("");
        login.getTbxPassword().sendKeys("");
        login.getBtnLogin().click();
    }
}