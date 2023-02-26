package tests.api;

import baseEntities.BaseApiTest;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class GetAFE extends BaseApiTest {

    @Test
    public void getUserWrongToken() {
        given()
                .auth().preemptive().oauth2("WRONG_TOKEN")
                .when()
                .log().uri()
                .get(Endpoints.GET_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    @Test
    public void wrongUserName() {
        given()
                .pathParam("username", "WRONG_NAME")
                .when()
                .log().uri()
                .get(Endpoints.GET_EXACT_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
