package baseEntities;

import adapters.RepositoryAdapter;
import adapters.UserAdapter;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import dbTables.RepositoryTable;
import dbTables.UserTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Repository;
import models.User;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.*;
import services.DataBaseService;
import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected Gson gson;
    protected DataBaseService dbService;
    protected UserAdapter userAdapter;
    protected UserTable userTable;
    protected RepositoryTable repositoryTable;
    protected RepositoryAdapter repositoryAdapter;

    public BaseApiTest() {
        this.dbService = new DataBaseService();
        this.userAdapter = new UserAdapter();
        this.userTable = new UserTable(dbService);
        this.repositoryTable = new RepositoryTable(dbService);
        this.repositoryAdapter = new RepositoryAdapter();
    }

    @BeforeSuite
    public void setUp(){
        repositoryTable.createTable();
        userTable.createTable();

        User expectedUser = User.builder()
                .login("AQA18onl")
                .type("User")
                .name("AQA18onlGr4")
                .company("TMS")
                .location("Poland")
                .email("AQA18onlGr4@gmail.com")
                .bio("AQA18onlGr4 Project")
                .publicRepos(1).build();
        userTable.addUser(expectedUser);

        Faker faker = new Faker();
        Repository repository = Repository.builder()
                .name(faker.pokemon().name())
                .description(faker.pokemon().location())
                .IsPrivate(false)
                .build();
        repositoryTable.addRepository(repository);

        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation().create();

        RestAssured.baseURI = ReadProperties.getApiUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().oauth2(ReadProperties.token())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
    
    @AfterSuite
    public void tearDown(){
        repositoryTable.dropTable();
        userTable.dropTable();
        dbService.closeConnection();
    }
}
