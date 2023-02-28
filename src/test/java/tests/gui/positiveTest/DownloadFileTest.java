package tests.gui.positiveTest;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import model.Repository;
import model.User;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

public class DownloadFileTest extends BaseTest {
    @Test
    public void downloadFileTest() {
        User user = User.builder()
                .userName(ReadProperties.username())
                .password(ReadProperties.password())
                .build();

        Repository repository = Repository.builder()
                .name("Kek21")
                .description("Test11232")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateButtonDownloadTest()
                .chooseFileButtonClick()
                .downloadFile()
                .getCheckDownloadFileLocator().shouldBe(visible);
    }
}
