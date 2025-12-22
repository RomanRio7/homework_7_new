package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TicketPage {

    private final SelenideElement ticketCountInput = $("#amount");
    private final SelenideElement cardNumberInput = $("#card\\.cardNumber");
    private final SelenideElement cardHolderInput = $("#card\\.cardholderName");
    private final SelenideElement monthDropdown = $("#month + select");
    private final SelenideElement yearDropdown = $("#year + select");
    private final SelenideElement cvcInput = $("#cvc");
    private final SelenideElement payButton = $$("button").findBy(text("Оплатить"));
    private final SelenideElement returnHomeButton = $$("button").findBy(text("Вернуться на главную"));

    private final SelenideElement body = $("body");

    public void setTicketCount(String count) {
        ticketCountInput.shouldBe(visible).setValue(count);
    }

    public void fillCard(String cardNumber, String holder, String month, String year, String cvc) {
        cardNumberInput.shouldBe(visible).setValue(cardNumber);
        cardHolderInput.shouldBe(visible).setValue(holder);
        monthDropdown.selectOptionByValue(month);
        yearDropdown.selectOptionByValue(year);
        cvcInput.shouldBe(visible).setValue(cvc);
    }

    public void pay() {
        payButton.shouldBe(visible).click();
    }

    public void waitForSuccess() {
        body.shouldHave(text("Спасибо за покупку"), Duration.ofSeconds(5));
    }

    public void returnHome() {
        returnHomeButton.shouldBe(visible).click();
    }
}