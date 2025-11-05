package steps;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.MoviePage;
import com.codeborne.selenide.Condition;


import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovieSteps {

    private final MainPage mainPage = new MainPage();
    private final MoviePage moviePage = new MoviePage();

    @Step("Открываем страницу фильма '{movieName}'")
    public void openMovieDetails(String movieName) {
        $$("div.rounded-xl.border.bg-card.text-card-foreground.shadow")
                .findBy(Condition.text(movieName))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .find("button")
                .click();
    }

    @Step("Оставляем отзыв: '{text}'")
    public void publishReview(String text) {
        moviePage.setReviewText(text);
        moviePage.clickSendReview();
    }

    @Step("Проверяем, что отзыв '{text}' отображается на странице")
    public void verifyReviewDisplayed(String reviewText) {
        boolean isDisplayed = $$("p.overflow-hidden.text-ellipsis.whitespace-pre-line.line-clamp-8")
                .findBy(Condition.text(reviewText))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .exists();

        assertTrue(isDisplayed, "Отзыв не отображается на странице фильма");
    }

    @Step("Удаляем отзыв: '{reviewText}'")
    public void deleteReview() {
        $("button[data-qa-id='movie_review_actions_button']")
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();

        $("div[data-qa-id='movie_review_action_delete_button']")
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();

        $(".review-container")
                .shouldBe(Condition.disappear, Duration.ofSeconds(10));
    }
}
