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
    @Test
 public void api1() {

        given()
                .when()
                .log().uri()
                .get("/user")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUsers() {
        given()
                .when()

                .log().uri()
                .get("/repos/AQA18onl/Test1/collaborators")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }
}
