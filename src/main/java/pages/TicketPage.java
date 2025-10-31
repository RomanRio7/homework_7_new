package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import java.time.Duration;

public class TicketPage {

    private final SelenideElement ticketCountInput = $("#amount");
    private final SelenideElement cardNumberInput = $("#card\\.cardNumber");
    private final SelenideElement cardHolderInput = $("#card\\.cardholderName");
    private final SelenideElement monthDropdown = $("#month + select");
    private final SelenideElement yearDropdown = $("#year + select");
    private final SelenideElement cvcInput = $("#cvc");
    private final SelenideElement payButton = $$("button").findBy(text("Оплатить"));
    private final SelenideElement returnHomeButton = $$("button").findBy(text("Вернуться на главную"));
    private final SelenideElement successNotification = $("body");

    public void setTicketCount(String count) {
        ticketCountInput.shouldBe(visible).setValue(count);
    }

    public void setCardNumber(String cardNumber) {
        cardNumberInput.shouldBe(visible).setValue(cardNumber);
    }

    public void setCardHolderName(String name) {
        cardHolderInput.shouldBe(visible).setValue(name);
    }

    public void selectMonth(String month) {
        monthDropdown.selectOptionByValue(month);
    }

    public void selectYear(String year) {
        yearDropdown.selectOptionByValue(year);
    }

    public void setCvc(String cvc) {
        cvcInput.shouldBe(visible).setValue(cvc);
    }

    public void clickPay() {
        payButton.shouldBe(visible).click();
    }

    public boolean isSuccessNotificationVisible() {
        return successNotification.shouldHave(text("Спасибо за покупку"), Duration.ofSeconds(2)).exists();
    }

    public void clickReturnHome() {
        returnHomeButton.shouldBe(visible).click();
    }
}
