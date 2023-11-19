import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Copyright extends BaseSettingsTest {
    @DisplayName("Copyright 2023. All Rights Reserved")
    @Description("Tikrinam Copyright 2023. All Rights Reserved")
    @Story("POSITIVE TEST")
    @Test
    @Order(8)
    void copyrightTest() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "768x1024";
        open("http://localhost:3000");
        SelenideElement footerTest = $x("//footer").shouldBe(visible)
                .shouldHave(text("Copyright 2023. All Rights Reserved"));

    }
}
