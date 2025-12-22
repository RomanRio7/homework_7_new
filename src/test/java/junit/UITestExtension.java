package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.TestConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.*;

import steps.LoginSteps;

public class UITestExtension implements BeforeAllCallback, BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.baseUrl = TestConfig.BASE_URL;
        Configuration.browser = TestConfig.BROWSER;
        Configuration.browserSize = TestConfig.BROWSER_SIZE;
        Configuration.timeout = TestConfig.TIMEOUT_MS;

        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true)
        );
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        new LoginSteps()
                .openLoginPage()
                .loginAsDefaultUser();
    }

    @Override
    public void afterEach(ExtensionContext context) {
        WebDriverRunner.closeWebDriver();
    }
}