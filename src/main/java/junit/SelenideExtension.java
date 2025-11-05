package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.*;

public class SelenideExtension implements BeforeAllCallback, AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.baseUrl = "https://cinescope.t-qa.ru";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        WebDriverRunner.closeWebDriver();
    }
}
