package pages.repository;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DownloadFilePage {
    private final SelenideElement chooseFileButton = $(By.xpath("//input[@type='file']"));
    private final SelenideElement checkDownloadFile = $(By.xpath("//div[text() = 'picture.jpg']"));

    public SelenideElement getChooseFileButton() {
        return chooseFileButton;
    }

    public SelenideElement getCheckDownloadFile() {
        return checkDownloadFile;
    }
}
