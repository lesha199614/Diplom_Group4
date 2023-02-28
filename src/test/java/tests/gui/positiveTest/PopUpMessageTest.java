package tests.gui.positiveTest;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import model.Repository;
import model.User;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;

public class PopUpMessageTest extends BaseTest {
    @Test
    public void popUpMessageTest() {
        User user = User.builder()
                .userName(ReadProperties.username())
                .password(ReadProperties.password())
                .build();

        Repository repository = Repository.builder()
                .name("NewRep2027")
                .description("Test12")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateButtonPopUpTest()
                .clickProjectButton()
                .getTmsLocator().hover().shouldHave(attribute("title", "TMS"));
    }
}


