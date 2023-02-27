package tests.api;

import baseEntities.BaseApiTest;
import com.github.javafaker.Faker;
import models.Repository;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RepositoryTest extends BaseApiTest {

    Repository expectedRepository;

    @Test
    public void dropTable() {

        repositoryTable.dropTable();
    }

    @Test(dependsOnMethods = "dropTable")
    public void createTable() {
        repositoryTable.createTable();
    }

    @Test(dependsOnMethods = "createTable")
    public void insertRepositoryToTheTable() {
        Faker faker = new Faker();
        expectedRepository = Repository.builder()
                .name(faker.pokemon().name())
                .description(faker.pokemon().location())
                .IsPrivate(false)
                .build();
        repositoryTable.addRepository(expectedRepository);
        Assert.assertEquals(repositoryTable.getRepository(1), expectedRepository);
    }


    @Test(dependsOnMethods = "insertRepositoryToTheTable")
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
        Assert.assertEquals(actualRepository,expectedRepository);
    }

    @Test(dependsOnMethods = "updateRepo")
    public void deleteRepository() {
        repositoryAdapter.deleteRepository(expectedRepository.getName());
    }

}
