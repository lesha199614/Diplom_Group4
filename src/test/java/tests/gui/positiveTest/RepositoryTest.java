package tests.gui.positiveTest;

import baseEntities.BaseTest;
import com.github.javafaker.Faker;
import configuration.ReadProperties;
import models.Repository;
import models.User;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;

public class RepositoryTest extends BaseTest {

    Repository repository;
    User user;

    @Test
    public void creatingRepositoryTest() {
        Faker faker = new Faker();
        user = User.builder()
                .name(ReadProperties.username())
                .password(ReadProperties.password())
                .build();

        repository = Repository.builder()
                .name(faker.beer().name().replaceAll(" ", ""))
                .description(faker.beer().name())
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateButtonCreateTest()
                .successfulCreationRepositoryPage().shouldBe(visible);
    }

    @Test(dependsOnMethods = "creatingRepositoryTest")
    public void downloadFileTest() {
        repositorySteps
                .chooseFileButtonClick()
                .downloadFile()
                .getCheckDownloadFileLocator().shouldBe(visible);
    }


    @Test(dependsOnMethods = "downloadFileTest")
    public void popUpMessageTest() {
        navigationSteps.clickProjectButton()
                .getTmsLocator().hover().shouldHave(attribute("title", "TMS"));
    }

    @Test(dependsOnMethods = "popUpMessageTest")
    public void displayingDialogBoxTest() {
        navigationSteps.openRepositories();
        navigationSteps.openRepositories().repos().get(0).click();
        navigationSteps.clickSettingButton()
                .clickDeleteRepositoryButtonDialogBoxTest()
                .getInputTextForDeleteRepositoryLocator().shouldBe(visible);
    }

    @Test(dependsOnMethods = "displayingDialogBoxTest")
    public void deleteRepositoryTest() {
        String textForDeletion = repositorySteps.getDeleteText();
        repositorySteps.inputDataForDeleteRepository(textForDeletion)
                .deleteRepositoryButton()
                .getTextAboutDeleteRepository().shouldBe(visible);
    }
}