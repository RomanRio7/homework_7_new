package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.FiltersSteps;

@UITest
public class FilterTest {

    private final FiltersSteps filtersSteps = new FiltersSteps();

    @Test
    public void successfulFilterApplication() {
        String expectedGenre = "Триллер";

        filtersSteps.openAllMovies();
        filtersSteps.applyFilters("SPB", expectedGenre);
        filtersSteps.openFirstFilteredMovie();
        filtersSteps.verifyMovieGenre(expectedGenre);
    }
}
