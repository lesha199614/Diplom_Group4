package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MenuPage {
    private final By iconPlusButtonLocator = By.className("dropdown-caret");
    private final By newRepositoryButtonLocator = By.xpath("//a[contains( text(),'New repository')]");

    public SelenideElement getIconPlusButtonLocator() {return $(iconPlusButtonLocator);}
    public SelenideElement getNewRepositoryButtonLocator() {return $(newRepositoryButtonLocator);}
}
