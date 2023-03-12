package tests.api;

import adapters.CollaboratorAdapter;
import baseEntities.BaseApiTest;
import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Endpoints;

import java.sql.SQLException;

import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseApiTest {

    Logger logger = LogManager.getLogger(UserApiTest.class);
    @Test
    public void getUser() {
        expectedUser = userTable.getUser(1);
        User actualUser = userAdapter.get();
        logger.info("Comparing expected user and user from the GitHub");
        Assert.assertEquals(actualUser, expectedUser);
    }
}
