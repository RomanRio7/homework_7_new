package steps;

import io.qameta.allure.Step;
import pages.FiltersPage;

public class FiltersSteps {
    private final FiltersPage filtersPage = new FiltersPage();

    @Step("Применяем фильтры: город = {city}, жанр = {genre}")
    public void applyFilters(String city, String genre) {
        filtersPage.selectCity(city);
        filtersPage.selectGenre(genre);
    }

    @Step("Открываем карточку первого фильма после фильтрации")
    public void openFirstFilteredMovie() {
        filtersPage.clickMoreButton();
    }
}
