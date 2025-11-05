package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FiltersPage {

    private final SelenideElement cityDropdown = $("[data-qa-id='movies_filter_location_select']").closest("button");
    private final SelenideElement genreDropdown = $$("button[role='combobox']").get(1);
    private final SelenideElement moreButton = $$("button").findBy(text("Подробнее"));

    public void selectCity(String city) {
        cityDropdown.shouldBe(visible).click();
        $$("div").findBy(text(city)).click();
    }

    public void selectGenre(String genre) {
        genreDropdown.shouldBe(visible).click();
        $$("div").findBy(text(genre)).click();
    }

    public void clickMoreButton() {
        moreButton.shouldBe(visible).click();
    }
}
