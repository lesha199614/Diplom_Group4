package tests.gui.positiveTest;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import model.Repository;
import model.User;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

public class DisplayingDialogBoxTest extends BaseTest {
    @Test
    public void displayingDialogBoxTest() {
        User user = User.builder()
                .userName(ReadProperties.username())
                .password(ReadProperties.password())
                .build();

        Repository repository = Repository.builder()
                .name("TestRepository123456")
                .description("This is test")
                .deletionInformation("AQA18onl/TestRepository")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateButtonDeleteTest()
                .clickSettingButton()
                .clickDeleteRepositoryButtonDialogBoxTest()
                .getInputTextForDeleteRepositoryLocator().shouldBe(visible);
    }
}
