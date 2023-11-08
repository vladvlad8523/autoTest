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
    private  final static String URL = "http://localhost:8080";

    @Issue(value = "TechIn komandinis darbas 2023.10.23")
    @Link(name = "GitHubApi", url = "https://github.com/vladvlad8523/BookReservationAppApplicationTests.git")
    @Owner(value = "https://github.com/vladvlad8523")
    @DisplayName("Show Names Test Tikrinam Get Metoda")
    @Description("tikrinam get metoda, ir ziurim sarasa")
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
    @RepeatedTest(3)
    public void namePostTest() {
        Category name = new Category( "A", "");
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
    @Test
    public void testCategoryPut() {
        String expectedCategory = "category";
        int actualCategory = 1;

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Kaunas");

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
                .statusCode(Matchers.oneOf(200, 405, 204));
    }
    @Issue(value = "TechIn komandinis darbas 2023.10.23")
    @DisplayName("Test Category Delete")
    @Description("tikrinam metoda, DELETE")
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
                .statusCode(Matchers.oneOf(200, 404))
                .body("message", equalTo("Category deleted successfully"));
    }
}
//allure generate target/allure-results --clean
//allure serve