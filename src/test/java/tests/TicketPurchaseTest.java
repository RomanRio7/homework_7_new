package tests;

import junit.UITest;
import org.junit.jupiter.api.Test;
import steps.FiltersSteps;
import steps.MainSteps;
import steps.MovieSteps;
import steps.TicketSteps;

@UITest
public class TicketPurchaseTest {

    private final MainSteps mainSteps = new MainSteps();
    private final FiltersSteps filtersSteps = new FiltersSteps();
    private final MovieSteps movieSteps = new MovieSteps();
    private final TicketSteps ticketSteps = new TicketSteps();

    @Test
    void shouldPurchaseTicketSuccessfully() {
        mainSteps.openAllMovies();
        filtersSteps.openFirstMovie();

        movieSteps.openTicketPurchase();
        ticketSteps.buyTicket("2", "4242424242424242", "Test User", "12", "25", "123");

        ticketSteps.shouldBeSuccessful();
        ticketSteps.returnHome();
    }
}