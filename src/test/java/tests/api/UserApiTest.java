package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseApiTest {

    User expectedUser;

    @Test
    public void getUser() {
        expectedUser = userTable.getUser(1);
        User actualUser = userAdapter.get();
        Assert.assertEquals(actualUser, expectedUser);
    }


    @Test
    public void get() {
        given()
                .when()
                .log().uri()
                .get(Endpoints.GET_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(User.class, ObjectMapperType.GSON);
    }

}
