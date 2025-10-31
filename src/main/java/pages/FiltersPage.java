package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FiltersPage {

    private final SelenideElement sityDropdown = $$("button[role='combobox']").findBy(text("Все"));
    private final SelenideElement genreDropdown = $$("button[role='combobox']").findBy(text("Все"));
    private final SelenideElement moreButton = $$("button").findBy(text("Подробнее"));

    public void selectCity(String сity) {
        sityDropdown.shouldBe(visible).click();
        $$("div").findBy(text(сity)).click();
    }

    public void selectGenre(String genre) {
        genreDropdown.shouldBe(visible).click();
        $$("div").findBy(text(genre)).click();
    }

    public void clickMoreButton() {
        moreButton.shouldBe(visible).click();
    }
}
