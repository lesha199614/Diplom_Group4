package pages.repository;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DownloadFilePage {
    private final By chooseFileButtonLocator = By.xpath("//input[@type='file']");
    private final By checkDownloadFileLocator = By.xpath("//div[text() = 'picture.jpg']");

    public SelenideElement getChooseFileButtonLocator() {
        return $(chooseFileButtonLocator);
    }

    public SelenideElement getCheckDownloadFileLocator() {
        return $(checkDownloadFileLocator);
    }
}
