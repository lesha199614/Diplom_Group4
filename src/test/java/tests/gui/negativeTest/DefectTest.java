package tests.gui.negativeTest;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import models.User;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;

public class DefectTest extends BaseTest {
    @Test
    public void defectTest() {
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
