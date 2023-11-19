import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import junit.framework.TestListener;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import java.util.Arrays;
import static com.codeborne.selenide.Selenide.*;

//@ExtendWith(TestListener)
@Feature("Testai atidaromi narsikleje ir spaudziamos nuorodos narsikleje")
public class PageClicTest extends BaseSettingsTest {
    Category name = new Category("A", "");
    String text = String.valueOf(name);

    @Issue(value = "TechIn komandinis darbas 2023.10.23")
    @Link(name = "GitHubApi", url = "https://github.com/vladvlad8523/")
    @Owner(value = "https://github.com/vladvlad8523")
    @DisplayName("Test Click Page")
    @Description("tikrinam linkus, fomrmas")
    @Story("CRASH TEST")
    @Test
    @Order(4)
    void testClick() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1680x1050";
        open("http://localhost:3000/");
        $x("//a/img").click();
        $x("//ul/li/a[@class='nav-link'][1]").click();
        /**
         * tikrinam forma categories
         * start
         * pvz.: Vardenis
         */
        $(By.cssSelector(".btn.btn-success")).click();
        $(By.className("form-control")).setValue(text);
        $(By.cssSelector("form > .btn.btn-primary")).click();
        $(By.name("category")).setValue(text);
        /**
         * end
         */
        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/books']").click();
        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/favorite']").click();
        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/reserved']").click();
        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/about']").click();
        $x("//div[@id='navbarSupportedContent']//input[@class='form-control me-2']").
                setValue("^(?!.*(.)\\1)[A-Z][a-z]{4,49}$").pressEnter();
    }
}