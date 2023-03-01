package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MenuPage {
    private final SelenideElement iconPlusButtonLocator = $(By.className("dropdown-caret"));
    private final SelenideElement newRepositoryButtonLocator = $(By.xpath("//a[contains( text(),'New repository')]"));

    public SelenideElement getIconPlusButtonLocator() {
        return iconPlusButtonLocator;
    }

    public SelenideElement getNewRepositoryButtonLocator() {
        return newRepositoryButtonLocator;
    }
}