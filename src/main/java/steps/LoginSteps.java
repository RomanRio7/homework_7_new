package steps;

import pages.LoginPage;
import static com.codeborne.selenide.Selenide.*;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    public void login(String email, String password) {
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        loginPage.verifyUserLoggedIn();
    }

    public void openLoginPage() {
        open("/login");
    }
}
