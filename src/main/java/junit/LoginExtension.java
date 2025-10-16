package junit;

import com.codeborne.selenide.Selenide;
import pages.LoginPage;
import org.junit.jupiter.api.extension.*;

public class LoginExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        Selenide.open("/login");
        new LoginPage().login("roman_sarsengaliev@mail.ru", "baXfo8-nyptyc-jicxob");
    }
}
