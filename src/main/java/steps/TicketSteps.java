package steps;

import io.qameta.allure.Step;
import pages.TicketPage;

public class TicketSteps {

    private final TicketPage ticketPage = new TicketPage();

    @Step("Покупаем {count} билет(а/ов): карта {cardNumber}, владелец {holder}")
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

    @Step("Проверяем успешную оплату билета")
    public boolean isPurchaseSuccessful() {
        return ticketPage.isSuccessNotificationVisible();
    }

    @Step("Возвращаемся на главную страницу")
    public void returnToMain() {
        ticketPage.clickReturnHome();
    }
}
