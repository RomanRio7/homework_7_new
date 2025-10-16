package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import steps.ReviewSteps;

@UITest
public class ReviewPublicationTest {

    private final MainPage mainPage = new MainPage();
    private final ReviewSteps reviewSteps = new ReviewSteps();

    @Test
    public void successfulReviewPublication() {
        String movieName = "Jujutsu kaisen";
        String reviewText = "Отличный фильм! Очень понравился сюжет и анимация.";

        reviewSteps.openMovieDetails(movieName);
        reviewSteps.publishReview(reviewText);
        reviewSteps.verifyReviewDisplayed(reviewText);
    }
}
