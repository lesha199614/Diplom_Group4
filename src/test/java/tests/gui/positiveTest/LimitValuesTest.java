package tests.gui.positiveTest;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;
import models.Repository;
import models.User;
import org.testng.annotations.Test;
import tests.data.StaticProvider;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;

public class LimitValuesTest extends BaseTest {
    //@Test(dataProvider = "dataForLimitValuesTest", dataProviderClass = StaticProvider.class)
    public void limitValuesTest(String data, Condition expected) {
        Repository repository = Repository.builder()
                .name(data)
                .build();

//        navigationSteps.clickSignInButtonOnMainPage()
//                .loginSuccessfulGitHub(user)
//                .clickNewRepositoryButton()
//                .inputInfoRepositoryByEmptyString(repository)
//                .getCreateRepositoryButtonByEmptyStringLocator().shouldBe(expected);


        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateRepositoryButton()
                .successfulCreationRepositoryPage()
                .shouldHave(expected);
    }


    @Test
    public void EmptyStringTest() {
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
