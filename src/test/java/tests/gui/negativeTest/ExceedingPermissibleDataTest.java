package tests.gui.negativeTest;

import baseEntities.BaseTest;
import models.Repository;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.attribute;

public class ExceedingPermissibleDataTest extends BaseTest {
    @Test
    public void exceedingPermissibleDataTest() {
        Repository repository = Repository.builder()
                .name("12345678910111213141516171819202122232425262728293031323334353637383940414243444546474849505152535455")
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
