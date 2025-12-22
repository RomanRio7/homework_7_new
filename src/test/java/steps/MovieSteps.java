package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.MoviePage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class MovieSteps {

    private final MoviePage moviePage = new MoviePage();

    @Step("Переходим к покупке билета")
    public void openTicketPurchase() {
        moviePage.clickBuyTicket();
    }

    @Step("Публикуем отзыв: {text}")
    public void publishReview(String text) {
        moviePage.typeReview(text);
        moviePage.sendReview();
    }

    @Step("Проверяем, что отзыв отображается: {text}")
    public void shouldSeeReview(String text) {
        $$("p.overflow-hidden.text-ellipsis.whitespace-pre-line.line-clamp-8")
                .findBy(Condition.text(text))
                .shouldBe(Condition.visible, Duration.ofSeconds(10));
    }

    @Step("Удаляем отзыв")
    public void deleteReview() {
        $("button[data-qa-id='movie_review_actions_button']")
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();

        $("div[data-qa-id='movie_review_action_delete_button']")
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .click();

        $(".review-container").shouldBe(Condition.disappear, Duration.ofSeconds(10));
    }

    @Step("Проверяем жанр фильма: ожидаем {expectedGenre}")
    public void shouldHaveGenre(String expectedGenre) {
        assertEquals(expectedGenre, moviePage.readGenre(), "Жанр фильма не совпадает с ожидаемым");
    }
}