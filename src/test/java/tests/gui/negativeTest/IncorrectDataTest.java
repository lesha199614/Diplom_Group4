package tests.gui.negativeTest;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import model.User;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class IncorrectDataTest extends BaseTest {
    @Test
    public void incorrectDataTest() {
        User user = User.builder()
                .userName(ReadProperties.username())
                .password("12345")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginIncorrect(user)
                .getIncorrectLoginLocator().shouldHave(text("Incorrect username or password."));
    }
}
