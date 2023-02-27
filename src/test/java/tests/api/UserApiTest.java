package tests.api;

import baseEntities.BaseApiTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest extends BaseApiTest {

    User expectedUser;

    @Test
    public void getUser() {
        expectedUser = userTable.getUser(1);
        User actualUser = userAdapter.get();
        Assert.assertEquals(actualUser, expectedUser);
    }

}
