package tests.Simple;

import baseEntities.BaseTest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

public class SimpleTest extends BaseTest {


    @Test
    public void test() throws InterruptedException {
        open("/");
        mainPage.getSignIn().click();
        Thread.sleep(4000);
    }


}
