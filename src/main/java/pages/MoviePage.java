package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import java.time.Duration;

public class MoviePage {

    private final SelenideElement buyTicketButton = $$("button").findBy(text("Купить билет"));
    private final SelenideElement genreText = $$("p.text-lg.mt-5").findBy(text("Жанр:"));
    private final SelenideElement reviewInput = $("[data-qa-id='movie_review_input']");
    private final SelenideElement sendReviewButton = $$("button").findBy(text("Отправить"));

    public void clickBuyTicket() {
        buyTicketButton.shouldBe(visible).click();
    }

    public String getMovieGenre() {
        return genreText.shouldBe(visible).getText().replace("Жанр:", "").trim();
    }

    public void setReviewText(String text) {
        reviewInput.shouldBe(visible, Duration.ofSeconds(1)).setValue(text);
    }

    public void clickSendReview() {
        sendReviewButton.shouldBe(visible).click();
    }
}
