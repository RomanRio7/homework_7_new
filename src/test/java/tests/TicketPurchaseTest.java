package tests;

import junit.UITest;
import steps.TicketSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@UITest
public class TicketPurchaseTest {

    private final TicketSteps ticketSteps = new TicketSteps();

    @Test
    public void successfulTicketPurchase() {
        String movieName = "Jujutsu kaisen";

        ticketSteps.selectMovie(movieName);
        ticketSteps.openTicketPurchase();
        ticketSteps.buyTicket("2", "4242424242424242", "Test User", "12", "25", "123");

        Assertions.assertTrue(ticketSteps.isPurchaseSuccessful(), "Покупка билета не прошла успешно");

        ticketSteps.returnToMain();
    }
}
