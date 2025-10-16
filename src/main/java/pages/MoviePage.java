package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MoviePage {
    public void clickBuyTicket() {
        $$("button").findBy(text("Купить билет")).click();
    }
}