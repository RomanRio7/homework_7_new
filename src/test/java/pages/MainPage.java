package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement allMoviesLink = $("a[href='/movies']");

    public void openAllMovies() {
        allMoviesLink.shouldBe(visible).click();
    }
}