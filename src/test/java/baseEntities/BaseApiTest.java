package baseEntities;

import adapters.CollaboratorAdapter;
import adapters.RepositoryAdapter;
import adapters.UserAdapter;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import dbTables.CollaboratorsTable;
import dbTables.RepositoryTable;
import dbTables.UserTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Collaborator;
import models.Repository;
import models.User;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.*;
import services.DataBaseService;


import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected Repository expectedRepository;
    protected Collaborator expectedCollaborator;
    protected User expectedUser;
    protected Gson gson;
    protected DataBaseService dbService;
    protected UserTable userTable;
    protected RepositoryTable repositoryTable;
    protected UserAdapter userAdapter;
    protected RepositoryAdapter repositoryAdapter;
    protected CollaboratorsTable collaboratorsTable;
    protected CollaboratorAdapter collaboratorAdapter;

//    public BaseApiTest() {
//        this.dbService = new DataBaseService();
//        this.userAdapter = new UserAdapter();
//        this.repositoryAdapter = new RepositoryAdapter();
//        this.collaboratorAdapter = new CollaboratorAdapter();
//        this.userTable = new UserTable(dbService);
//        this.repositoryTable = new RepositoryTable(dbService);
//        this.collaboratorsTable = new CollaboratorsTable(dbService);
//    }

    //@BeforeSuite
    public void setUp() {
        repositoryTable.dropTable();
        userTable.dropTable();
        collaboratorsTable.dropTable();
        repositoryTable.createTable();
        userTable.createTable();
        collaboratorsTable.createTable();

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

        Collaborator collaborator = Collaborator.builder()
                .id(126247707)
                .login("AQA18onl")
                .type("User")
                .roleName("admin")
                .build();
        collaboratorsTable.addCollaborator(collaborator);

        Faker faker = new Faker();
        Repository repository = Repository.builder()
                .name(faker.pokemon().name().replaceAll(" ", ""))
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

    //@AfterTest
    public void tearDown() {
        repositoryTable.dropTable();
        userTable.dropTable();
        collaboratorsTable.dropTable();
        dbService.closeConnection();
    }
}
