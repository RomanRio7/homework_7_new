package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement allMoviesButton = $x("//a[text()='Все фильмы']");

    public void clickAllMoviesButton() {
        allMoviesButton.click();
    }
}
