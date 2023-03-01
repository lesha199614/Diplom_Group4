package steps;

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

    public UserSteps clickSignInButtonOnMainPage() {
        mainPage.getSignInButtonLocator().click();
        return new UserSteps();
    }

    public RepositorySteps clickNewRepositoryButton() {
        menuPage.getIconPlusButtonLocator().click();
        menuPage.getNewRepositoryButtonLocator().click();
        return new RepositorySteps();
    }

    public SuccessCreationRepositoryPage clickCreateRepositoryButton() {
        createRepositoryPage.getCreateRepositoryButtonLocator().click();
        return successCreationRepositoryPage;
    }

    public ProjectPage clickProjectButton() {
        successCreationRepositoryPage.getProjectButtonLocator().click();
        return new ProjectPage();
    }

    public NavigationSteps clickSettingButton() {
        successCreationRepositoryPage.getSettingButtonLocator().click();
        return this;
    }

    public RepositorySettingsPage clickDeleteRepositoryButtonDialogBoxTest() {
        repositorySettingsPage.getDeleteRepositoryButtonLocator().click();
        return new RepositorySettingsPage();
    }

    public ListRepositoriesPage deleteRepositoryButton() {
        repositorySettingsPage.getConfirmDeleteRepositoryButtonLocator().click();
        return new ListRepositoriesPage();
    }

    public ListRepositoriesPage openRepositories() {
        repositorySettingsPage.getRepositories().click();
        return new ListRepositoriesPage();
    }
}
