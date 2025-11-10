package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {
    private final MainPage mainPage = new MainPage();

    @Step("Открываем страницу со всеми фильмами")
    public void openAllMovies() {
        mainPage.clickAllMoviesButton();
    }
}
