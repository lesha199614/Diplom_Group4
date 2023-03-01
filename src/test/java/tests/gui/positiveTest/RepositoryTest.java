package tests.gui.positiveTest;

import baseEntities.BaseTest;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;

public class RepositoryTest extends BaseTest {
    @Test
    public void creatingRepositoryTest() {
        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateRepositoryButton()
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
