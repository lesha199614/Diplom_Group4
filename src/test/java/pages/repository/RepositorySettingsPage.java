package pages.repository;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RepositorySettingsPage {
    private final By deleteRepositoryButtonLocator = By.xpath
            ("//summary[contains( text(),'Delete this repository')]");
    private final By inputTextForDeleteRepositoryLocator = By.cssSelector
            ("input[aria-label='Type in the name of the repository to confirm that you want to delete this repository.']");
    private final By confirmDeleteRepositoryButtonLocator = By.xpath
            ("//span[text() = 'I understand the consequences, delete this repository']");

    public SelenideElement getDeleteRepositoryButtonLocator() {
        return $(deleteRepositoryButtonLocator);
    }

    public SelenideElement getInputTextForDeleteRepositoryLocator() {
        return $(inputTextForDeleteRepositoryLocator).shouldBe(visible);
    }

    public SelenideElement getConfirmDeleteRepositoryButtonLocator() {
        return $(confirmDeleteRepositoryButtonLocator).shouldBe(enabled);
    }
}
