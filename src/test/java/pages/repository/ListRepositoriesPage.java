package pages.repository;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ListRepositoriesPage {
    private final By textAboutDeleteRepository = By.xpath
            ("//div[contains( text(), 'successfully deleted')]");

    public SelenideElement getTextAboutDeleteRepository() {
        return $(textAboutDeleteRepository);
    }
}
