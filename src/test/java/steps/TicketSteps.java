package steps;

import io.qameta.allure.Step;
import pages.TicketPage;

public class TicketSteps {

    private final TicketPage ticketPage = new TicketPage();

    @Step("Покупаем {count} билет(а/ов)")
    public void buyTicket(String count, String cardNumber, String holder, String month, String year, String cvc) {
        ticketPage.setTicketCount(count);
        ticketPage.fillCard(cardNumber, holder, month, year, cvc);
        ticketPage.pay();
    }

    @Step("Проверяем успешную оплату")
    public void shouldBeSuccessful() {
        ticketPage.waitForSuccess();
    }

    @Step("Возвращаемся на главную страницу")
    public void returnHome() {
        ticketPage.returnHome();
    }
}