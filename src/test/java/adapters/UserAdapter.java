package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class UserAdapter {

    Logger logger = LogManager.getLogger(UserAdapter.class);

    public User get() {
        logger.info("Getting user");
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
