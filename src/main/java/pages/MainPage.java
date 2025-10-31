package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement allMoviesButton = $x("//a[text()='Все фильмы']");
    private final SelenideElement firstDetailsButton = $x("(//button[normalize-space()='Подробнее'])[1]");

    public void clickAllMoviesButton() {
        allMoviesButton.click();
    }

    public void clickFirstMovieDetails() {
        executeJavaScript("arguments[0].click();", firstDetailsButton);
    }
}
