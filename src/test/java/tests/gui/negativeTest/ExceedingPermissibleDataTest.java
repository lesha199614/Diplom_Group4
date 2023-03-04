package tests.gui.negativeTest;

import baseEntities.BaseTest;
import models.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class ExceedingPermissibleDataTest extends BaseTest {
    Logger logger = LogManager.getLogger(ExceedingPermissibleDataTest.class);
    @Test
    public void exceedingPermissibleDataTest() {
        logger.info("Enter more characters in the storage name and check if there should not be so many characters");
        Repository repository = Repository.builder()
                .name(faker.bothify("?????????????????????????????????????????????????????????????????????????????????????????????????????"))
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateRepositoryButton()
                .successfulCreationRepositoryPage()
                .shouldNotHave(text(repository.getName()));
    }
}
