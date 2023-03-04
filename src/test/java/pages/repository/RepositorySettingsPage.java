package pages.repository;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RepositorySettingsPage {
    private final SelenideElement deleteRepositoryButtonLocator = $(By.xpath
            ("//summary[contains( text(),'Delete this repository')]"));
    private final SelenideElement inputTextForDeleteRepositoryLocator = $(By.cssSelector
            ("input[aria-label='Type in the name of the repository to confirm that you want to delete this repository.']"));
    private final SelenideElement confirmDeleteRepositoryButtonLocator = $(By.xpath
            ("//span[text() = 'I understand the consequences, delete this repository']"));
    private final SelenideElement repositoriesLocator = $(By.xpath("//a[@data-tab-item='repositories']"));

    private final SelenideElement deleteText = $(By.xpath("//p[contains(text(), 'Please type')]/strong"));

    public SelenideElement getDeleteRepositoryButtonLocator() {
        return deleteRepositoryButtonLocator;
    }

    public SelenideElement getInputTextForDeleteRepositoryLocator() {
        return inputTextForDeleteRepositoryLocator.shouldBe(visible);
    }

    public SelenideElement getConfirmDeleteRepositoryButtonLocator() {
        return confirmDeleteRepositoryButtonLocator.shouldBe(enabled);
    }

    public SelenideElement getRepositories() {
        return repositoriesLocator.shouldBe(enabled);
    }

    public SelenideElement delete() {
        return deleteText;
    }
}
