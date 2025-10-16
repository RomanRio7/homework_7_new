package tests;

import junit.UITest;
import pages.MainPage;
import steps.TicketSteps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@UITest
public class TicketPurchaseTest {

    private final MainPage mainPage = new MainPage();
    private final TicketSteps ticketSteps = new TicketSteps();


    @Test
    public void successfulTicketPurchase() {
        String movieName = "Jujutsu kaisen";

        mainPage.clickMovieDetails(movieName);

        ticketSteps.openTicketPurchase();
        ticketSteps.buyTicket("2", "4242424242424242", "Test User", "12", "25", "123");

        Assertions.assertTrue(ticketSteps.isPurchaseSuccessful(), "Покупка билета не прошла успешно");

        ticketSteps.returnToMain();
    }
}
