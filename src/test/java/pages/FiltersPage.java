package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FiltersPage {

    private final SelenideElement cityDropdown =
            $("[data-qa-id='movies_filter_location_select']").closest("button");

    private final SelenideElement genreDropdown =
            $$("button[role='combobox']").get(1);

    private final SelenideElement firstMovieCard =
            $$("div.rounded-xl.border.bg-card.text-card-foreground.shadow").first();

    public void selectCity(String city) {
        cityDropdown.shouldBe(visible).click();
        $$("div[role='option'], div").findBy(text(city)).shouldBe(visible).click();
    }

    public void selectGenre(String genre) {
        genreDropdown.shouldBe(visible).click();
        $$("div[role='option'], div").findBy(text(genre)).shouldBe(visible).click();
    }

    public void openFirstMovieDetails() {
        firstMovieCard.shouldBe(visible)
                .$$("button")
                .findBy(text("Подробнее"))
                .shouldBe(visible)
                .click();
    }
}