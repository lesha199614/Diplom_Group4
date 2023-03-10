package pages.repository;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class CreateRepositoryPage {
    private final SelenideElement inputRepositoryName = $("#repository_name");
    private final SelenideElement inputDescriptionRepository = $("#repository_description");
    private final SelenideElement createRepositoryButton = $(By.xpath("//button[contains( text(),'Create repository')]"));

    public SelenideElement getInputRepositoryName() {
        return inputRepositoryName;
    }

    public SelenideElement getInputDescriptionRepository() {
        return inputDescriptionRepository;
    }

    public SelenideElement getCreateRepositoryButton() {
        return createRepositoryButton.shouldBe(enabled);
    }

    public SelenideElement getCreateRepositoryButtonByEmptyStringLocator() {
        return createRepositoryButton;
    }
}
