package junit;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import steps.LoginSteps;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.openLoginPage();
        loginSteps.login("roman_sarsengaliev@mail.ru", "baXfo8-nyptyc-jicxob");
    }
}
