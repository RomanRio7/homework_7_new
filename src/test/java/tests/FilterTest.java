package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.FiltersSteps;
import steps.MainSteps;
import steps.MovieSteps;

@UITest
public class FilterTest {

    private final MainSteps mainSteps = new MainSteps();
    private final FiltersSteps filtersSteps = new FiltersSteps();
    private final MovieSteps movieSteps = new MovieSteps();

    @Test
    void shouldFilterMoviesByGenre() {
        String expectedGenre = "Триллер";

        mainSteps.openAllMovies();
        filtersSteps.apply("SPB", expectedGenre).openFirstMovie();
        movieSteps.shouldHaveGenre(expectedGenre);
    }
}