package tests.gui.positiveTest;

import baseEntities.LimitBaseTest;
import models.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;

public class LimitValuesTestLimit extends LimitBaseTest {
    Logger logger = LogManager.getLogger(LimitValuesTestLimit.class);

    @Test
    public void EmptyStringTest() {
        logger.info("Check the boundary values with an empty string.Check the inclusion of the button");
        Repository repository = Repository.builder()
                .name("")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepositoryByEmptyString(repository)
                .getCreateRepositoryButtonByEmptyStringLocator().shouldBe(disabled);
    }

    @Test
    public void positiveCharacter1Test() {
        logger.info("Check the limit values with 1 character. Check if the storage was created with 1 character");
        Repository repository = Repository.builder()
                .name(faker.bothify("?"))
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateRepositoryButton()
                .successfulCreationRepositoryPage()
                .shouldHave(text(repository.getName()));
    }

    @Test
    public void positiveCharacters100Test() {
        logger.info("Check the limit values using 100 characters. Check if the storage has been created, using 100 characters");
        Repository repository = Repository.builder()
                .name(faker.bothify("????????????????????????????????????????????????????????????????????????????????????????????????????"))
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateRepositoryButton()
                .successfulCreationRepositoryPage()
                .shouldHave(text(repository.getName()));
    }

    @Test
    public void negativeCharacters101Test() {
        logger.info("Check the limit values using 101 characters. Check if the storage has been created, using 101 characters");
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