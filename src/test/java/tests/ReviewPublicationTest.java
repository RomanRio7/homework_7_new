package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.MovieSteps;

@UITest
public class ReviewPublicationTest {

    private final MovieSteps reviewSteps = new MovieSteps();

    @Test
    public void successfulReviewPublication() {
        String movieName = "Jujutsu kaisen";
        String reviewText = "Отличный фильм! Очень понравился сюжет и анимация.";

        reviewSteps.openMovieDetails(movieName);
        reviewSteps.publishReview(reviewText);
        reviewSteps.verifyReviewDisplayed(reviewText);
        reviewSteps.deleteReview();
    }
}
