package steps;

import io.qameta.allure.Step;
import pages.MenuPage;
import pages.MainPage;
import pages.ProjectPage;
import pages.repository.CreateRepositoryPage;
import pages.repository.ListRepositoriesPage;
import pages.repository.RepositorySettingsPage;
import pages.repository.SuccessCreationRepositoryPage;

public class NavigationSteps {
    private MainPage mainPage;
    private MenuPage menuPage;
    private SuccessCreationRepositoryPage successCreationRepositoryPage;
    private CreateRepositoryPage createRepositoryPage;
    private RepositorySettingsPage repositorySettingsPage;

    public NavigationSteps() {
        mainPage = new MainPage();
        menuPage = new MenuPage();
        successCreationRepositoryPage = new SuccessCreationRepositoryPage();
        createRepositoryPage = new CreateRepositoryPage();
        repositorySettingsPage = new RepositorySettingsPage();
    }
    @Step
    public UserSteps clickSignInButtonOnMainPage() {
        mainPage.getSignInButtonLocator().click();
        return new UserSteps();
    }

    @Step
    public RepositorySteps clickNewRepositoryButton() {
        menuPage.getIconPlusButtonLocator().click();
        menuPage.getNewRepositoryButtonLocator().click();
        return new RepositorySteps();
    }

    @Step
    public SuccessCreationRepositoryPage clickCreateRepositoryButton() {
        createRepositoryPage.getCreateRepositoryButtonLocator().click();
        return successCreationRepositoryPage;
    }

    @Step
    public ProjectPage clickProjectButton() {
        successCreationRepositoryPage.getProjectButtonLocator().click();
        return new ProjectPage();
    }

    @Step
    public NavigationSteps clickSettingButton() {
        successCreationRepositoryPage.getSettingButton().click();
        return this;
    }

    @Step
    public RepositorySettingsPage clickDeleteRepositoryButtonDialogBoxTest() {
        repositorySettingsPage.getDeleteRepositoryButtonLocator().click();
        return new RepositorySettingsPage();
    }

    @Step
    public ListRepositoriesPage deleteRepositoryButton() {
        repositorySettingsPage.getConfirmDeleteRepositoryButtonLocator().click();
        return new ListRepositoriesPage();
    }

    @Step
    public ListRepositoriesPage openRepositories() {
        repositorySettingsPage.getRepositories().click();
        return new ListRepositoriesPage();
    }
}
