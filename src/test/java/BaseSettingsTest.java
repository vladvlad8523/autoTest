import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;


abstract public class BaseSettingsTest {
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.webdriverLogsEnabled = true;
        Configuration.browserSize = "1680x1050";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 10000;

    }
    @Before
    public void  init() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
        setUp();
    }
    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
