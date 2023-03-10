package tests.gui.negativeTest;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

public class DefectTest extends BaseTest {
    Logger logger = LogManager.getLogger(DefectTest.class);
    //@Test
    public void defectTest() {
        logger.info("Making an intentional mistake, to get a screenshot of the error");
        User user = User.builder()
                .name(ReadProperties.username())
                .password("12345")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateRepositoryButton()
                .successfulCreationRepositoryPage().shouldBe(visible);
    }
}
