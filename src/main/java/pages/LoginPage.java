package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

public class LoginPage {

    private final SelenideElement emailInput = $("input[type='email']");
    private final SelenideElement passwordInput = $("input[type='password']");
    private final SelenideElement loginButton = $$("button").findBy(text("Войти"));
    private final SelenideElement profileButton = $$("button").findBy(text("Профиль"));

    @Step("Вводим email: {email}")
    public void setEmail(String email) {
        emailInput.shouldBe(visible).setValue(email);
    }

    @Step("Вводим пароль")
    public void setPassword(String password) {
        passwordInput.shouldBe(visible).setValue(password);
    }

    @Step("Нажимаем кнопку 'Войти'")
    public void clickLoginButton() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Проверяем, что пользователь успешно вошёл в систему")
    public void verifyUserLoggedIn() {
        profileButton.shouldBe(visible, Duration.ofSeconds(10));
        assertTrue(profileButton.exists(), "Пользователь не вошёл в систему — кнопка 'Профиль' не найдена");
    }
}
