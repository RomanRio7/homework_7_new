package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MoviePage {

    private final SelenideElement buyTicketButton = $$("button").findBy(text("Купить билет"));
    private final SelenideElement genreText = $$("p.text-lg.mt-5").findBy(text("Жанр:"));
    private final SelenideElement reviewInput = $("[data-qa-id='movie_review_input']");
    private final SelenideElement sendReviewButton = $$("button").findBy(text("Отправить"));

    public void clickBuyTicket() {
        buyTicketButton.shouldBe(visible).click();
    }

    public String readGenre() {
        return genreText.shouldBe(visible).getText().replace("Жанр:", "").trim();
    }

    public void typeReview(String text) {
        reviewInput.shouldBe(visible, Duration.ofSeconds(5)).setValue(text);
    }

    public void sendReview() {
        sendReviewButton.shouldBe(visible).click();
    }
}