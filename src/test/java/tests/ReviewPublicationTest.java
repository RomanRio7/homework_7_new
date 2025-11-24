package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.MainSteps;
import steps.MovieSteps;

@UITest
public class ReviewPublicationTest {

    private final MovieSteps movieSteps = new MovieSteps();
    private final MainSteps mainSteps = new MainSteps();

    @Test
    public void successfulReviewPublication() {
        String movieName = "Фильм автотест a80df678-8135-491a-b55d-3d016aedacca";
        String reviewText = "Отличный фильм! Очень понравился сюжет и анимация.";

        mainSteps.selectMovie(movieName);
        movieSteps.publishReview(reviewText);
        movieSteps.verifyReviewDisplayed(reviewText);
        movieSteps.deleteReview();
    }
}
