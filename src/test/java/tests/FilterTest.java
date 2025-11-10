package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.MainSteps;
import steps.FiltersSteps;
import steps.MovieSteps;

@UITest
public class FilterTest {

    private final MainSteps mainPageSteps = new MainSteps();
    private final FiltersSteps filtersSteps = new FiltersSteps();
    private final MovieSteps movieSteps = new MovieSteps();

    @Test
    public void successfulFilterApplication() {
        String expectedGenre = "Триллер";

        mainPageSteps.openAllMovies();
        filtersSteps.applyFilters("SPB", expectedGenre);
        filtersSteps.openFirstFilteredMovie();

        movieSteps.verifyMovieGenre(expectedGenre);
    }
}
