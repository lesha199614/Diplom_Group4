package tests.api;

import baseEntities.BaseApiTest;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

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
