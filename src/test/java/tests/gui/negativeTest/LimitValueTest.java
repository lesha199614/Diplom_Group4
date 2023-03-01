package tests.gui.negativeTest;

import baseEntities.BaseTest;
import models.Repository;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.disabled;

public class LimitValueTest extends BaseTest {
    @Test
    public void emptyStringTest() {
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
    public void characters101Test() {
        Repository repository = Repository.builder()
                .name("dsjlkfghkdsjhfgsudfhgkjshdfkljhdskjfhlshdkljfhdslhjfsldhflksdfhjsdjkfhjksdhfkdshflshdfhjsdhkfasdfghja")
                .build();

        navigationSteps.clickSignInButtonOnMainPage()
                .loginSuccessfulGitHub(user)
                .clickNewRepositoryButton()
                .inputInfoRepository(repository)
                .clickCreateRepositoryButton()
                .successfulCreationRepositoryPage()
                .shouldHave(attribute("value",
                        "git@github.com:AQA18onl/dsjlkfghkdsjhfgsudfhgkjshdfkljhdskjfhlshdkljfhdslhjfsldhflksdfhjsdjkfhjksdhfkdshflshdfhjsdhkfasdfghj.git"));
    }
}
