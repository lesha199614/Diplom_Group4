package pages.repository;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class CreateRepositoryPage {
    private final By inputRepositoryNameLocator = By.cssSelector("#repository_name");
    private final By inputDescriptionRepositoryLocator = By.cssSelector("#repository_description");
    private final By createRepositoryButtonLocator = By.xpath("//button[contains( text(),'Create repository')]");

    public SelenideElement getInputRepositoryNameLocator() {
        return $(inputRepositoryNameLocator);
    }

    public SelenideElement getInputDescriptionRepositoryLocator() {
        return $(inputDescriptionRepositoryLocator);
    }

    public SelenideElement getCreateRepositoryButtonLocator() {
        return $(createRepositoryButtonLocator).shouldBe(enabled);
    }
}
