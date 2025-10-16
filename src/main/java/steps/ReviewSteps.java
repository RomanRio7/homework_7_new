package steps;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.ReviewPage;
import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$$;



import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReviewSteps {

    private final MainPage mainPage = new MainPage();
    private final ReviewPage reviewPage = new ReviewPage();

    @Step("Открываем страницу фильма '{movieName}'")
    public void openMovieDetails(String movieName) {
        mainPage.clickMovieDetails(movieName);
    }

    @Step("Оставляем отзыв: '{text}' с оценкой {rating} звёзд")
    public void publishReview(String text) {
        reviewPage.writeReview(text);
        reviewPage.submitReview();
    }

    @Step("Проверяем, что отзыв '{text}' отображается на странице")
    public void verifyReviewDisplayed(String reviewText) {
        boolean isDisplayed = $$("p.overflow-hidden.text-ellipsis.whitespace-pre-line.line-clamp-8")
                .findBy(Condition.text(reviewText))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .exists();

        assertTrue(isDisplayed, "Отзыв не отображается на странице фильма");
    }

}
