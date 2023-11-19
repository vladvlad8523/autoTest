import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;


abstract public class BaseSettingsTest {
    private WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.webdriverLogsEnabled = true;
        Configuration.browserSize = "1680x1050";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = false;
        Configuration.screenshots = true;
        Configuration.timeout = 10000;

    }
    @Before
    public void  init() {
        WebDriverRunner.setWebDriver(driver);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        setUp();
    }
    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
