package pages.repository;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SuccessCreationRepositoryPage {
    private final SelenideElement checkSuccessfulCreationRepository = $(By.xpath("//*[@id='repository-container-header']//strong/a"));
    private final SelenideElement settingButton = $(By.cssSelector("#settings-tab"));
    private final String projectButtonLocator = "//a[contains (text(), 'replace')]";
    private final SelenideElement proceedToFileDownloadButton = $(By.linkText("uploading an existing file"));

    public SelenideElement successfulCreationRepositoryPage() {
        return checkSuccessfulCreationRepository;
    }

    public SelenideElement getSettingButton() {
        return settingButton;
    }

    public SelenideElement getProjectButtonLocator(String name) {
        return $(By.xpath(projectButtonLocator.replace("replace", name)));
    }

    public SelenideElement getProceedToFileDownloadButton() {
        return proceedToFileDownloadButton;
    }
}