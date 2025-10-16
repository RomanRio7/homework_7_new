package pages;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class TicketPage {
    public void setTicketCount(String count) {
        $("#amount").setValue(count);
    }

    public void setCardNumber(String cardNumber) {
        $("#card\\.cardNumber").setValue(cardNumber);
    }

    public void setCardHolderName(String name) {
        $("#card\\.cardholderName").setValue(name);
    }

    public void selectMonth(String month) {
        actions().moveToElement($("#month")).click().perform();
        $("#month + select").selectOptionByValue(month);
    }

    public void selectYear(String year) {
        actions().moveToElement($("#year")).click().perform();
        $("#year + select").selectOptionByValue(year);
        $("body").click();
    }

    public void setCvc(String cvc) {
        $("#cvc").setValue(cvc);
    }

    public void clickPay() {
        $$("button").findBy(text("Оплатить")).click();
    }

    public boolean isSuccessNotificationVisible() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return $("body").has(text("Спасибо за покупку"));
    }

    public void clickReturnHome() {
        $$("button").findBy(text("Вернуться на главную")).click();
    }
}
