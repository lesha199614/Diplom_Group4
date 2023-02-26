package baseEntities;

import adapters.UserAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import dbTables.UserTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected Gson gson;
    protected DataBaseService dbService;
    protected UserAdapter userAdapter;
    protected UserTable userTable;

    @BeforeTest
    public void setupApi() {
        userAdapter = new UserAdapter();
        dbService = new DataBaseService();
        Gson gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().create();

        RestAssured.baseURI = ReadProperties.getApiUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().oauth2(ReadProperties.token())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        userTable = new UserTable(dbService);
    }

    @AfterTest
    public void closeDb() {
        dbService.closeConnection();
    }
}
