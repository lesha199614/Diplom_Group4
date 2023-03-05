package adapters;

import configuration.ReadProperties;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import models.Collaborator;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CollaboratorAdapter {

    Logger logger = LogManager.getLogger(CollaboratorAdapter.class);
    public List<Collaborator> getCollaborators(String repositoryOwner, String repositoryName) {
        logger.info("Getting list of Collaborators");
        List<Collaborator> collaboratorList = new ArrayList<>();
        collaboratorList = given()
                .when()
                .pathParam("owner", repositoryOwner)
                .pathParam("repo", repositoryName)
                .log().uri()
                .get("/repos/{owner}/{repo}/collaborators")
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getList("",Collaborator.class);
        return collaboratorList;
    }

}
