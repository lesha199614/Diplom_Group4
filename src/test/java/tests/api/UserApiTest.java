package tests.api;

import baseEntities.BaseApiTest;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseApiTest {

    User expectedUser;

    @Test
    public void dropTable() {
        userTable.dropTable();
    }

    @Test(dependsOnMethods = "dropTable")
    public void createTable() {
        userTable.createTable();
    }

    @Test(dependsOnMethods = "createTable")
    public void insertUserToTheTable() {
        expectedUser = User.builder()
                .login("AQA18onl")
                .type("User")
                .name("AQA18onlGr4")
                .company("TMS")
                .location("Poland")
                .email("AQA18onlGr4@gmail.com")
                .bio("AQA18onlGr4 Project")
                .publicRepos(2).build();
        userTable.addUser(expectedUser);
        Assert.assertEquals(userTable.getUser(1), expectedUser);
    }

    @Test(dependsOnMethods = "insertUserToTheTable")
    public void api1() {
        expectedUser = userTable.getUser(1);
        User actualUser = userAdapter.get();
        Assert.assertEquals(actualUser, expectedUser);
    }

}
