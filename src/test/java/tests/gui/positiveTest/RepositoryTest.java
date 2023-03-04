package tests.gui.positiveTest;

import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;

public class RepositoryTest extends BaseTest {
    Logger logger = LogManager.getLogger(RepositoryTest.class);
    @Test
    public void creatingRepositoryTest() {
        logger.info("Create a repository and make sure it is created");
        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateRepositoryButton()
                .successfulCreationRepositoryPage().shouldBe(visible);
    }

    @Test(dependsOnMethods = "creatingRepositoryTest")
    public void downloadFileTest() {
        logger.info("Upload the file to our repository and make sure it is loaded");
        repositorySteps
                .chooseFileButtonClick()
                .downloadFile()
                .getCheckDownloadFileLocator().shouldBe(visible);
    }


    @Test(dependsOnMethods = "downloadFileTest")
    public void popUpMessageTest() {
        logger.info("Checking the pop-up window");
        navigationSteps.clickProjectButton()
                .getTmsLocator().hover().shouldHave(attribute("title", "TMS"));
    }

    @Test(dependsOnMethods = "popUpMessageTest")
    public void displayingDialogBoxTest() {
        logger.info("Checking the dialog box");
        navigationSteps.openRepositories();
        navigationSteps.openRepositories().repos().get(0).click();
        navigationSteps.clickSettingButton()
                .clickDeleteRepositoryButtonDialogBoxTest()
                .getInputTextForDeleteRepositoryLocator().shouldBe(visible);
    }

    @Test(dependsOnMethods = "displayingDialogBoxTest")
    public void deleteRepositoryTest() {
        logger.info("Remove the repository and make sure it is deleted");
        textForDeletion = repositorySteps.getDeleteText();
        repositorySteps.inputDataForDeleteRepository(textForDeletion)
                .deleteRepositoryButton()
                .getTextAboutDeleteRepository().shouldBe(visible);
    }
}
