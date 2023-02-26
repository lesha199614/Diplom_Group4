package tests.api;

import baseEntities.BaseApiTest;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class PostAFE extends BaseApiTest {

    @Test
    public void createRepositoryEmptyBody() {
        given()
                .when()
                .log().body()
                .post(Endpoints.CREATE_REPOSITORY)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void createRepositoryWrongToken() {
        given()
                .auth().preemptive().oauth2("WRONG_TOKEN")
                .when()
                .log().body()
                .post(Endpoints.CREATE_REPOSITORY)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

}
