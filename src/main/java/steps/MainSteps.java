package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.MainPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$;

public class MainSteps {
    private final MainPage mainPage = new MainPage();

    @Step("Выбираем фильм '{movieName}'")
    public void selectMovie(String movieName) {
        $$("div.rounded-xl.border.bg-card.text-card-foreground.shadow")
                .findBy(Condition.text(movieName))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .find("button")
                .click();
    }

    @Step("Открываем страницу со всеми фильмами")
    public void openAllMovies() {
        mainPage.clickAllMoviesButton();
    }
}
