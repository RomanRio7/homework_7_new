package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.FiltersPage;
import steps.FiltersSteps;

@UITest
public class FilterTest {

    private final MainPage mainPage = new MainPage();
    private final FiltersPage filtersPage = new FiltersPage();
    private final FiltersSteps filtersSteps = new FiltersSteps();

    @Test
    public void successfulFilterApplication() {
        mainPage.clickAllMoviesButton();

        filtersPage.selectSity("SPB");
        filtersPage.selectGenre("Триллер");
        filtersPage.clickMoreButton();
    }
}
