package tests;

import junit.UITest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import steps.MovieSteps;
import steps.TicketSteps;
import steps.MainSteps;

@UITest
public class TicketPurchaseTest {

    private final MovieSteps movieSteps = new MovieSteps();
    private final TicketSteps ticketSteps = new TicketSteps();
    private final MainSteps mainSteps = new MainSteps();

    @Test
    public void successfulTicketPurchase() {
        String movieName = "Фильм автотест a80df678-8135-491a-b55d-3d016aedacca";

        // Выбираем фильм
        mainSteps.selectMovie(movieName);

        // Переходим к покупке (этот степ теперь в MainPageSteps)
        movieSteps.openTicketPurchase();

        // Покупаем билет
        ticketSteps.buyTicket("2", "4242424242424242", "Test User", "12", "25", "123");

        // Проверяем, что покупка успешна
        Assertions.assertTrue(ticketSteps.isPurchaseSuccessful(),
                "Покупка билета не прошла успешно");

        // Возвращаемся на главную страницу
        ticketSteps.returnToMain();
    }
}
