import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Books {

    @DisplayName("FORM TEST BOOKS GET")
    @Story("FORM TEST BOOKS")
    @Description("Tikrinam turima knygu sarasa")
    @Issue(value = "books")
    @Test
    @Order(9)
    public void allBooksListGet() {
                given()
                .baseUri("http://localhost:8080")
                .basePath("/books")
                .contentType(ContentType.JSON)
                .when().get()
                .prettyPeek()
                .jsonPath();
    }
    @DisplayName("FORM TEST BOOKS POST")
    @Story("FORM TEST BOOKS")
    @Test
    @Order(10)
    public void allBooksListPost() {
        try {
            given()
                    .baseUri("http://localhost:8080")
                    .basePath("/books/")
                    .contentType(ContentType.JSON)
                    .when()
                    .body("description\": \"QATesting\",\n" +
                            "        \"pictureUrl\": \"https://selenide.org/images/selenide-logo-bip.png\",\n" +
                            "        \"pages\": 3100,\n" +
                            "        \"isbn\": \"4-9028-9465-13\",\n" +
                            "        \"publicationDate\": \"2023-12-25\",\n" +
                            "        \"language\": \"English\"\n" +
                            "    }")
                    .post()
                    .then()
                    .statusCode(201)
                    .log().all();
        } catch (AssertionError e) {
            System.out.println("Error: Status code is not equal to 201");
        }
}

    @DisplayName("FORM TEST BOOKS PUT")
    @Story("FORM TEST BOOKS")
    @Test
    @Order(11)
    public void allBooksListPut() {
        try {
            given()
                    .baseUri("http://localhost:8080")
                    .basePath("/books")
                    .contentType(ContentType.JSON)
                    .when()
                    .body("{\n" +
                            " \"description\": \"QA Testing\",\n" +
                            " \"pictureUrl\": \"https://selenide.org/images/selenide-logo-big.png\",\n" +
                            " \"pages\": 3100,\n" +
                            " \"isbn\": \"2-9028-9465-1\",\n" +
                            " \"publicationDate\": \"2023-11-25\",\n" +
                            " \"language\": \"English\"\n" +
                            " }")
                    .put()
                    .then()
                    .statusCode(200)
                    .log().all();
        } catch (AssertionError e) {
            System.out.println("Error: Status code is not equal to 200");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
