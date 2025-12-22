package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.FiltersSteps;
import steps.MainSteps;
import steps.MovieSteps;

@UITest
public class ReviewPublicationTest {

    private final MainSteps mainSteps = new MainSteps();
    private final FiltersSteps filtersSteps = new FiltersSteps();
    private final MovieSteps movieSteps = new MovieSteps();

    @Test
    void shouldPublishAndDeleteReview() {
        String reviewText = "Отличный фильм! Очень понравился сюжет и анимация.";

        mainSteps.openAllMovies();
        filtersSteps.openFirstMovie();

        movieSteps.publishReview(reviewText);
        movieSteps.shouldSeeReview(reviewText);
        movieSteps.deleteReview();
    }
}