package tests.gui.positiveTest;

import baseEntities.BaseTest;
import com.codeborne.selenide.Condition;
import models.Repository;
import org.testng.annotations.Test;
import tests.data.StaticProvider;

import static com.codeborne.selenide.Condition.attribute;

public class LimitValuesTest extends BaseTest {
//    @Test(dataProvider = "dataForLimitValuesTest", dataProviderClass = StaticProvider.class)
//    public void emptyString(String data, Condition expected) {
//        Repository repository = Repository.builder()
//                .name(data)
//                .build();
//
//        navigationSteps.clickSignInButtonOnMainPage()
//                .loginSuccessfulGitHub(user)
//                .clickNewRepositoryButton()
//                .inputInfoRepositoryByEmptyString(repository)
//                .getCreateRepositoryButtonByEmptyStringLocator().shouldBe(expected);
//    }

    @Test
    public void character1Test() {
        Repository repository = Repository.builder()
                .name("Q")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateRepositoryButton()
                .successfulCreationRepositoryPage()
                .shouldHave(attribute("value", "git@github.com:AQA18onl/Q.git"));
    }

    @Test
    public void characters100Test() {
        Repository repository = Repository.builder()
                .name("1234567891011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateRepositoryButton()
                .successfulCreationRepositoryPage()
                .shouldHave(attribute("value",
                        "git@github.com:AQA18onl/1234567891011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545.git"));
    }
}
