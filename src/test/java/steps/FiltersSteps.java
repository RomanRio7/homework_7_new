package steps;

import io.qameta.allure.Step;
import pages.FiltersPage;

public class FiltersSteps {

    private final FiltersPage filtersPage = new FiltersPage();

    @Step("Применяем фильтры: город={city}, жанр={genre}")
    public FiltersSteps apply(String city, String genre) {
        filtersPage.selectCity(city);
        filtersPage.selectGenre(genre);
        return this;
    }

    @Step("Открываем первый фильм в выдаче")
    public void openFirstMovie() {
        filtersPage.openFirstMovieDetails();
    }
}