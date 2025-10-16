package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import java.time.Duration;

public class LoginPage {
    public void login(String email, String password) {
        $("input[type='email']").setValue(email);
        $("input[type='password']").setValue(password);
        $$("button").findBy(text("Войти")).click();
        $("button").shouldHave(text("Профиль"), Duration.ofSeconds(15));
    }
}