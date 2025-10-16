package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import java.time.Duration;

public class ReviewPage {

    public void writeReview(String text) {
        $("[data-qa-id='movie_review_input']")
                .shouldBe(visible, Duration.ofSeconds(10))
                .setValue(text);
    }

    public void submitReview() {
        $$("button").findBy(text("Отправить")).click();
    }
}
