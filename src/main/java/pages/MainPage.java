package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import java.time.Duration;

public class MainPage {

    public void clickAllMoviesButton() {
        $x("//a[text()='Все фильмы']")
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }

    public void clickMovieDetails(String movieName) {
        $$("div").findBy(text(movieName))
                .parent()
                .$$("button").findBy(text("Подробнее"))
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
    }
}
