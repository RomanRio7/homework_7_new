package steps;

import io.qameta.allure.Step;
import pages.FiltersPage;
import pages.MainPage;
import org.junit.jupiter.api.Assertions;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class FiltersSteps {
    private final MainPage mainPage = new MainPage();
    private final FiltersPage filtersPage = new FiltersPage();

    @Step("Открываем страницу со всеми фильмами")
    public void openAllMovies() {
        mainPage.clickAllMoviesButton();
    }

    @Step("Применяем фильтр по жанру {genre}")
    public void applyGenreFilter(String genre) {
        filtersPage.selectGenre(genre);
    }

    @Step("Проверяем, что фильм на странице соответствует жанру {genre}")
    public void verifyMovieGenre(String genre) {
        boolean isCorrectGenre = filtersPage.verifyMovieGenre(genre);
        Assertions.assertTrue(isCorrectGenre, "Жанр фильма не совпадает с ожидаемым!");
    }

}
