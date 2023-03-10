package pages.repository;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RepositorySettingsPage {
    private final SelenideElement deleteRepositoryButton = $(By.xpath
            ("//summary[contains( text(),'Delete this repository')]"));
    private final SelenideElement inputTextForDeleteRepository = $(By.cssSelector
            ("input[aria-label='Type in the name of the repository to confirm that you want to delete this repository.']"));
    private final SelenideElement confirmDeleteRepositoryButton = $(By.xpath
            ("//span[text() = 'I understand the consequences, delete this repository']"));
    private final SelenideElement repositories = $(By.xpath("//a[@data-tab-item='repositories']"));

    private final SelenideElement deleteText = $(By.xpath("//p[contains(text(), 'Please type')]/strong"));

    public SelenideElement getDeleteRepositoryButton() {
        return deleteRepositoryButton;
    }

    public SelenideElement getInputTextForDeleteRepository() {
        return inputTextForDeleteRepository.shouldBe(visible);
    }

    public SelenideElement getConfirmDeleteRepositoryButton() {
        return confirmDeleteRepositoryButton.shouldBe(enabled);
    }

    public SelenideElement getRepositories() {
        return repositories.shouldBe(enabled);
    }

    public SelenideElement delete() {
        return deleteText;
    }
}
