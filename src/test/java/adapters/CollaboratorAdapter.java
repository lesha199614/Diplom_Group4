package adapters;

import configuration.ReadProperties;
import io.restassured.mapper.ObjectMapperType;
import models.Collaborator;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class CollaboratorAdapter {


    public Collaborator getCollaborator(String repositoryOwner, String repositoryName) {
        return given()
                .when()
                .pathParam("owner", repositoryOwner)
                .pathParam("repo", repositoryName)
                .log().uri()
                .get("/repos/{owner}/{repo}/collaborators")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Collaborator.class, ObjectMapperType.GSON);
    }

}
