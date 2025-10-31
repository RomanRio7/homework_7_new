package steps;

import io.qameta.allure.Step;
import pages.FiltersPage;
import pages.MainPage;
import pages.MoviePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiltersSteps {
    private final MainPage mainPage = new MainPage();
    private final FiltersPage filtersPage = new FiltersPage();
    private final MoviePage moviePage = new MoviePage();

    @Step("Открываем страницу со всеми фильмами")
    public void openAllMovies() {
        mainPage.clickAllMoviesButton();
    }

    @Step("Применяем фильтры: город = {city}, жанр = {genre}")
    public void applyFilters(String city, String genre) {
        filtersPage.selectCity(city);
        filtersPage.selectGenre(genre);
    }

    @Step("Открываем карточку первого фильма после фильтрации")
    public void openFirstFilteredMovie() {
        filtersPage.clickMoreButton();
    }

    @Step("Проверяем, что жанр фильма совпадает с ожидаемым ({expectedGenre})")
    public void verifyMovieGenre(String expectedGenre) {
        String actualGenre = moviePage.getMovieGenre();
        assertEquals(expectedGenre, actualGenre, "Жанр фильма не совпадает с ожидаемым!");
    }
}
