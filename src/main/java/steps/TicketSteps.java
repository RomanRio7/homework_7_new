package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.MoviePage;
import pages.TicketPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class TicketSteps {

    private final MoviePage moviePage = new MoviePage();
    private final TicketPage ticketPage = new TicketPage();

    @Step("Выбор первого фильма")
    public void selectMovie(String movieName) {
        $$("div.rounded-xl.border.bg-card.text-card-foreground.shadow")
                .findBy(Condition.text(movieName))
                .shouldBe(Condition.visible, Duration.ofSeconds(10))
                .find("button")
                .click();
    }

    @Step("Переход к покупке билета")
    public void openTicketPurchase() {
        moviePage.clickBuyTicket();
    }

    @Step("Покупка билета: {count} шт., карта: {cardNumber}, владелец: {holder}")
    public void buyTicket(String count, String cardNumber, String holder,
                          String month, String year, String cvc) {
        ticketPage.setTicketCount(count);
        ticketPage.setCardNumber(cardNumber);
        ticketPage.setCardHolderName(holder);
        ticketPage.selectMonth(month);
        ticketPage.selectYear(year);
        ticketPage.setCvc(cvc);
        ticketPage.clickPay();
    }

    @Step("Проверка успешной оплаты")
    public boolean isPurchaseSuccessful() {
        return ticketPage.isSuccessNotificationVisible();
    }

    @Step("Возврат на главную страницу")
    public void returnToMain() {
        ticketPage.clickReturnHome();
    }
}
