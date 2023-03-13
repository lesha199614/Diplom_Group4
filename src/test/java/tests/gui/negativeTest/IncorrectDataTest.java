package tests.gui.negativeTest;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class IncorrectDataTest extends BaseTest {
    Logger logger = LogManager.getLogger(IncorrectDataTest.class);

    @Test
    public void incorrectDataTest() {
        logger.info("Enter the wrong password when logging into your account, and check for an error");
        User user = User.builder()
                .name(ReadProperties.username())
                .password("12345")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginIncorrect(user)
                .getIncorrectLoginLocator().shouldHave(text("Incorrect username or password."));
    }
}