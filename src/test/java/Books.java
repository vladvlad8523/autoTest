import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static javax.swing.UIManager.getString;

public class Books {
    @DisplayName("FORM TEST BOOKS")
    @Description("Tikrinam turima knygu sarasa")
    @Story("booksFormTest")
    @Issue(value = "books")
    @Test
    @Order(9)
    public void allBooksList() {
                given()
                .filter(new AllureRestAssured())
                .log().all()
                .header("categories","books")
                .when()
                .contentType(ContentType.JSON)
                .get("http://localhost:8080/books")
                .then().log().all()
                .statusCode(200);


    }

}
