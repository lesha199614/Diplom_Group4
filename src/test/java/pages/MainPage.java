package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement signInButtonLocator = $(By.xpath("//a[contains( text(), 'Sign in')]"));

    public SelenideElement getSignInButtonLocator() {
        return signInButtonLocator;
    }
}
