import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

class ResolutionTest extends BaseSettingsTest {
    @DisplayName("iPhoneProTest 390x844")
    @Description("Tikrinam Resolution 390x844")
    @Story("POSITIVE TEST")
    @Test
    @Order(5)
    public void iPhone12ProTest() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "390x844"; //todo klaida selenide 7.0.2 ir WebDriver v. 4.15.0
        open("http://localhost:3000/");
        $x("//img").click();
        $x("//span").click();
    }
    @DisplayName("iPhone4Test 320x480")
    @Description("Tikrinam Resolution 320x480")
    @Story("POSITIVE TEST")
    @Test
    @Order(6)
    public void iPhone4Test() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "320x480";
        open("http://localhost:3000/");
        $x("//img").click();
        $x("//span").click();
    }
    @DisplayName("galaxyS5Test 360x640")
    @Description("Tikrinam Resolution 360x640")
    @Story("POSITIVE TEST")
    @Test
    @Order(7)
    public void galaxyS5Test() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "360x640";
        open("http://localhost:3000/");
        $x("//img").click();
        $x("//span").click();
    }
}
