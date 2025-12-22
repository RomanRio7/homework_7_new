package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement emailInput = $("input[type='email']");
    private final SelenideElement passwordInput = $("input[type='password']");
    private final SelenideElement loginButton = $$("button").findBy(com.codeborne.selenide.Condition.text("Войти"));
    private final SelenideElement profileButton = $$("button").findBy(com.codeborne.selenide.Condition.text("Профиль"));

    public LoginPage typeEmail(String email) {
        emailInput.shouldBe(visible).setValue(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordInput.shouldBe(visible).setValue(password);
        return this;
    }

    public void submit() {
        loginButton.shouldBe(visible).click();
    }

    public void waitUntilLoggedIn() {
        profileButton.shouldBe(visible, Duration.ofSeconds(10));
    }
}