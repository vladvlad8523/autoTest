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
//@Feature("Testai atidaromi narsikleje ir spaudziamos nuorodos narsikleje")
public class PageClicTest extends BaseSettingsTest {
    Category name = new Category("H", "");
    String text = String.valueOf(name);

    @Issue(value = "TechIn komandinis darbas 2023.10.23")
    @Link(name = "GitHubApi", url = "https://github.com/vladvlad8523/")
    @Owner(value = "https://github.com/vladvlad8523")
    @DisplayName("Test Click Page")
    @Description("tikrinam linkus, fomrmas")
    @Story("TEST FOR THE CLIENT")
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
        /**
         * tikrinam forma books FORMA
         * start
         * pvz.: Vardenis
         */
        $x("//input[@class='form-control'][1]").setValue(text);
        $x("//input[@class='form-control'][2]").setValue(text);
        $x("//div[@id='root']/main/div/form/select[@name='category']/option[@value='Kaunas']").click();
        $x("//button[@class='btn btn-primary rounded-circle ']").click();
        $x("//div[@id='root']/main/div/form/select[@name='category']/option[@value='Kaunas']").click();
        $x("//textarea[@name='description']").setValue("Description" + text);
        $x("//form/input[@name='pictureUrl']")
                .setValue("https://media.istockphoto.com/id/1326978045/photo/lonely-big-tree-growing-up-on-ancient-books-like-a-painting-in-literature.jpg?s=612x612&w=0&k=20&c=bedRj10WevmGKOltdrCbo5FVRBRE1c9LI5pj_E3m4AE=");
        $x("//form/input[@name='pages']").setValue(text);
        $x("//form/input[@name='isbn']").setValue(text);
        $x("//form/input[@name='publicationDate']").setValue(text);
        $x("//form/input[@name='language']").setValue(text);
        $x("//div[@id='root']/main/div/form/button[@class='btn btn-primary']").click();
        /**
         * end
         */
        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/favorite']").click();
        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/reserved']").click();
        $x("//div[@id='navbarSupportedContent']/ul//a[@href='/about']").click();
        $x("//div[@id='navbarSupportedContent']//input[@class='form-control me-2']").
                setValue("^(?!.*(.)\\1)[A-Z][a-z]{4,49}$").pressEnter();
    }
}