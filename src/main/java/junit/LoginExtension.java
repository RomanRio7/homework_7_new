package junit;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import steps.LoginSteps;

public class LoginExtension implements BeforeAllCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.openLoginPage();
        loginSteps.login("roman_sarsengaliev@mail.ru", "baXfo8-nyptyc-jicxob");
    }
}
