import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

class BookReservationAppApplicationTests extends BaseSettingsTest {
    private final static String URL = "http://localhost:8080";

    @Issue(value = "TechIn komandinis darbas 2023.10.23")
    @Link(name = "GitHubApi", url = "https://github.com/vladvlad8523/")
    @Owner(value = "https://github.com/vladvlad8523")
    @DisplayName("Show Names Test Tikrinam Get Metoda")
    @Description("tikrinam get metoda, ir ziurim sarasa")
    @Story("POSITIVE TEST")
    @Test
    void showNamesTest() {
        String users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/categories")
                .then().log().all()
                .statusCode(200)
                .extract().body().jsonPath().getString("name");
    }

    @Issue(value = "TechIn komandinis darbas 2023.10.23")
    @DisplayName("POST TEST 3x random")
    @Description("tikrinam metoda, POST")
    @Story("NEGATIVE TEST") //todo
    @RepeatedTest(3)
    public void namePostTest() {
        Category name = new Category("A", "");
        try {
            String category = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(name)
                    .when()
                    .post(URL + "/categories")
                    .then().log().all()
                    .assertThat().statusCode(Matchers.oneOf(201))
                    .extract().response().jsonPath().getString("name");

        } catch (Exception e) {
            System.out.println("error JSON: " + e.getMessage());

        }
    }

    @Issue(value = "TechIn komandinis darbas 2023.10.23")
    @DisplayName("POST TEST 3x")
    @Description("tikrinam metoda, POST")
    @Story("POSITIVE TEST")
    @RepeatedTest(3)
    @Step
    public void namePostTest2() {
        Category name = new Category("A", "");
        try {
            String category = given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(name)
                    .when()
                    .post(URL + "/categories")
                    .then().log().all()
                    .assertThat().statusCode(equalTo(201))
                    .extract().response().jsonPath().getString("name");
            System.out.println("Status code 201, category name: " + category);
        } catch (AssertionError e) {
            System.out.println("Error: Status code is not equal to 201");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Issue(value = "TechIn komandinis darbas 2023.10.23")
    @DisplayName("Test Category Put")
    @Description("tikrinam metoda, PUT")
    @Story("POSITIVE TEST")
    @Test
    public void testCategoryPut() {
        try {
        String expectedCategory = "category";
        int actualCategory = 1;

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Mariampole");

        given()
                .filter(new AllureRestAssured())
                .log().all()
                .pathParam("id", actualCategory)
                .log().body()
                .contentType(ContentType.JSON)  // Use ContentType.JSON to set the request content type
                .body(requestBody.toString())  // Convert the JSON object to a string
                .when()
                .put(URL + "/categories/{id}")
                .prettyPeek()
                .then()
                .log().body()
                .statusCode(Matchers.oneOf(200));
            System.out.println("Status code 200, category name: " + actualCategory);
        } catch (AssertionError e) {
            System.out.println("Error: Status code is not equal to 404");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: Status code is not equal to 204 " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Issue(value = "TechIn komandinis darbas 2023.10.23")
    @DisplayName("Test Category Delete")
    @Description("tikrinam metoda, DELETE")
    @Story("POSITIVE TEST")
    @Test
    public void testCategoryDelete() {
        int categoryId = 1;

        given()
                .filter(new AllureRestAssured())
                .log().all()
                .pathParam("id", categoryId)
                .when()
                .delete(URL + "/categories/{id}")
                .prettyPeek()
                .then()
                .log().body()
                .statusCode(Matchers.oneOf(200, 404));
    }
}
/*
todo: allure generate target/allure-results --clean
todo: allure serve
todo: mvn clean test -Dtest="BookReservationAppApplicationTests#showNamesTest"
todo: sudo service jenkins stop
*/
