package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {
    private final By tmsLocator = By.xpath("//span[@title= 'TMS']");

    public SelenideElement getTmsLocator() {return $(tmsLocator);}
}
