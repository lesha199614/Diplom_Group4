package tests.api;

import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseApiTest {

    User expectedUser;

    @Test
    public void getUser() {
        expectedUser = userTable.getUser(1);
        User actualUser = userAdapter.get();
        Assert.assertEquals(actualUser, expectedUser);
    }

}
