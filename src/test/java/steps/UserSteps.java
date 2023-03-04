package steps;

import io.qameta.allure.Step;
import models.Repository;
import models.User;
import pages.LoginPage;
import pages.repository.SuccessCreationRepositoryPage;

public class UserSteps {
    private LoginPage loginPage;

    public UserSteps() {
        loginPage = new LoginPage();
    }


    public UserSteps inputLoginData(String userName, String password) {
        loginPage.getUserNameInputLocator().setValue(userName);
        loginPage.getPasswordInputLocator().setValue(password);
        return this;
    }

    @Step
    public UserSteps clickButtonSignInLoginPage() {
        loginPage.getLoginButtonLocator().click();
        return this;
    }

    @Step
    public NavigationSteps loginSuccessfulGitHub(User user) {
        inputLoginData(user.getName(), user.getPassword());
        clickButtonSignInLoginPage();
        return new NavigationSteps();
    }

    @Step
    public LoginPage loginIncorrect(User user) {
        inputLoginData(user.getName(), user.getPassword());
        clickButtonSignInLoginPage();
        return loginPage;
    }
}
