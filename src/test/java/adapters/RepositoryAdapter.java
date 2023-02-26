package adapters;

import configuration.ReadProperties;
import io.restassured.mapper.ObjectMapperType;
import models.Repository;
import models.User;
import org.apache.http.HttpStatus;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class RepositoryAdapter {

    public void createRepository(Repository repository) {
        given()
                .body(repository, ObjectMapperType.GSON)
                .when()
                .log().body()
                .post(Endpoints.CREATE_REPOSITORY)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED);
    }

    public Repository getRepository(String repositoryName) {
        return given()
                .pathParam("owner", ReadProperties.owner())
                .pathParam("repo", repositoryName)
                .when()
                .log().uri()
                .get(Endpoints.GET_REPOSITORY)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Repository.class, ObjectMapperType.GSON);
    }

    public Repository updateRepository(Repository repository) {
        return given()
                .pathParam("repo", repository.getName())
                .pathParam("owner", ReadProperties.owner())
                .body(repository, ObjectMapperType.GSON)
                .when()
                .log().body()
                .patch(Endpoints.UPDATE_REPOSITORY)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Repository.class, ObjectMapperType.GSON);
    }

    public void deleteRepository(String repositoryName) {
        given()
                .pathParam("repo", repositoryName)
                .pathParam("owner", ReadProperties.owner())
                .when()
                .log().uri()
                .delete(Endpoints.DELETE_REPOSITORY)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
