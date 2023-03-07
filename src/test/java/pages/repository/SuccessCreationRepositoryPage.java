package pages.repository;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SuccessCreationRepositoryPage {
    private final SelenideElement checkSuccessfulCreationRepositoryLocator = $(By.xpath("//*[@id='repository-container-header']//strong/a"));
    private final SelenideElement settingButton = $(By.cssSelector("#settings-tab"));
    private final SelenideElement projectButtonLocator = $(By.xpath("//a[contains (text(), 'AQA18onl')]"));
    private final SelenideElement proceedToFileDownloadButton = $(By.linkText("uploading an existing file"));

    public SelenideElement successfulCreationRepositoryPage() {
        return checkSuccessfulCreationRepositoryLocator;
    }

    public SelenideElement getSettingButton() {
        return settingButton;
    }

    public SelenideElement getProjectButtonLocator() {
        return projectButtonLocator;
    }

    public SelenideElement getProceedToFileDownloadButton() {
        return proceedToFileDownloadButton;
    }
}
