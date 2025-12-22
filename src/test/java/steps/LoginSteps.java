package steps;

import config.TestConfig;
import io.qameta.allure.Step;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();

    @Step("Открываем страницу логина")
    public LoginSteps openLoginPage() {
        open("/login");
        return this;
    }

    @Step("Логинимся пользователем по умолчанию")
    public LoginSteps loginAsDefaultUser() {
        return login(TestConfig.USER_EMAIL, TestConfig.USER_PASSWORD);
    }

    @Step("Логинимся пользователем {email}")
    public LoginSteps login(String email, String password) {
        loginPage.typeEmail(email)
                .typePassword(password);
        loginPage.submit();
        loginPage.waitUntilLoggedIn();
        return this;
    }
}