import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Copyright {
    @DisplayName("Copyright 2023. All Rights Reserved")
    @Description("Tikrinam ar yra Copyright 2023. All Rights Reserved")
    @Story("POSITIVE TEST")
    @Test
    public void copyrightTest() {
           open("http://localhost:3000");
        SelenideElement selenideElement = $x("//footer").shouldHave(text("Copyright 2023. All Rights Reserved"));

    }
}
