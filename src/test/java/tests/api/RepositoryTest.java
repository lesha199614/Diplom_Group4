package tests.api;

import baseEntities.BaseApiTest;
import com.github.javafaker.Faker;
import models.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepositoryTest extends BaseApiTest {
    Logger logger = LogManager.getLogger(RepositoryTest.class);

    Repository expectedRepository;

    @Test
    public void createRepo() {
        expectedRepository = repositoryTable.getRepository(1);
        repositoryAdapter.createRepository(expectedRepository);
    }

    @Test(dependsOnMethods = "createRepo")
    public void getRepository() {
        Repository actualRepository = repositoryAdapter.getRepository(expectedRepository.getName());
        Assert.assertEquals(actualRepository,expectedRepository);
    }

    @Test(dependsOnMethods = "getRepository")
    public void updateRepo() {
        expectedRepository = repositoryTable.getRepository(1);
        expectedRepository.setDescription("New Description");
        Repository actualRepository = repositoryAdapter.updateRepository(expectedRepository);
        logger.info("Comparing expected Repository and updated Repository in the GitHub");
        Assert.assertEquals(actualRepository,expectedRepository);
    }

    @Test(dependsOnMethods = "updateRepo")
    public void deleteRepository() {
        repositoryAdapter.deleteRepository(expectedRepository.getName());
    }

}