import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class Books extends BaseSettingsTest {
    @DisplayName("booksFormTest")
    @Description("Tikrinam turima knygu sarasa")
    @Story("FORM TEST BOOKS")
    @Issue(value = "books")
    @Test
    @Order(9)
    public void allBooks() { // pasiimam visaS REIKSMES
        JsonPath books = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .when()
                .body("") //irasyti kuna/aprasa name, iban(yra validacija)...
                .get("http://localhost:3000/books/")
                .prettyPeek()
                .body()
                .jsonPath();
        Assertions.assertEquals(books.get("data.get"), "categories", "nerado jokiu kategoriju");
    }
}
