package tests;

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

    @Test
    public void api() {
        Gson gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().create();

        RestAssured.baseURI = "https://api.github.com/";

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        given()
                .when()
                .log().uri()
                .get("users/AQA18onl/repos")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }


}
