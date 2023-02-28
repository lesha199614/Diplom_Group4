package steps;

import model.Repository;
import pages.repository.CreateRepositoryPage;
import pages.repository.DownloadFilePage;
import pages.repository.RepositorySettingsPage;
import pages.repository.SuccessCreationRepositoryPage;

import java.io.File;

public class RepositorySteps {
    private CreateRepositoryPage createRepositoryPage;
    private RepositorySettingsPage repositorySettingsPage;
    private SuccessCreationRepositoryPage successCreationRepositoryPage;
    private DownloadFilePage downloadFilePage;

    public RepositorySteps() {
        createRepositoryPage = new CreateRepositoryPage();
        repositorySettingsPage = new RepositorySettingsPage();
        successCreationRepositoryPage = new SuccessCreationRepositoryPage();
        downloadFilePage = new DownloadFilePage();
    }

    public NavigationSteps inputInfoRepository(Repository repository) {
        createRepositoryPage.getInputRepositoryNameLocator().click();
        createRepositoryPage.getInputRepositoryNameLocator().setValue(repository.getName());
        createRepositoryPage.getInputDescriptionRepositoryLocator().click();
        createRepositoryPage.getInputDescriptionRepositoryLocator().setValue(repository.getDescription());
        return new NavigationSteps();
    }

    public NavigationSteps inputDataForDeleteRepository(Repository repository) {
        repositorySettingsPage.getInputTextForDeleteRepositoryLocator().click();
        repositorySettingsPage.getInputTextForDeleteRepositoryLocator().setValue(repository.getDeletionInformation());
        return new NavigationSteps();
    }

    public RepositorySteps chooseFileButtonClick() {
        successCreationRepositoryPage.getProceedToFileDownloadButton().click();
        return this;
    }

    public DownloadFilePage downloadFile() {
        downloadFilePage.getChooseFileButtonLocator().uploadFile(new File("src/test/resources/picture.jpg"));
        return downloadFilePage;
    }
}
