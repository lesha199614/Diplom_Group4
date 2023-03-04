package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class UserAdapter {

    public User get() {
        return given()
                .when()
                .log().uri()
                .get(Endpoints.GET_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(User.class, ObjectMapperType.GSON);
    }
}
