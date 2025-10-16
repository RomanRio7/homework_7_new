package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class FiltersPage {
    public void selectSity(String sity) {
        $$("button[role='combobox']").findBy(text("Все")).click();
        $$("div").findBy(text(sity)).click();
        sleep(1000);
    }

    public void selectGenre(String genre) {
        $$("button[role='combobox']").findBy(text("Все")).click();
        $$("div").findBy(text(genre)).click();
        sleep(1000);
    }

    public void clickMoreButton() {
        $$("button")
                .findBy(text("Подробнее"))
                .shouldBe(visible)
                .click();
    }

    public boolean verifyMovieGenre(String genre) {
        return $$("p.text-lg.mt-5").texts().stream().anyMatch(text -> text.contains(genre));
    }
}
