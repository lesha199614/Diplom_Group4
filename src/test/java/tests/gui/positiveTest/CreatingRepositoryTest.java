package tests.gui.positiveTest;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import model.Repository;
import model.User;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

public class CreatingRepositoryTest extends BaseTest {
    @Test
    public void creatingRepositoryTest() {
        User user = User.builder()
                .userName(ReadProperties.username())
                .password(ReadProperties.password())
                .build();

        Repository repository = Repository.builder()
                .name("RepNumber22")
                .description("Test1")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateButtonCreateTest()
                .successfulCreationRepositoryPage().shouldBe(visible);
    }
}
