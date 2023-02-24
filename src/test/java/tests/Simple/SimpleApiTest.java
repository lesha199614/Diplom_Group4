package tests.Simple;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SimpleApiTest extends BaseApiTest {

    @Test
    public void api() {

        given()
                .when()
                .log().uri()
                .get("/users/AQA18onl/repos")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }
}
