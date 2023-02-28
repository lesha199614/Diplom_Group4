package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final By signInButtonLocator = By.cssSelector(".HeaderMenu-link--sign-in");

    public SelenideElement getSignInButtonLocator() {return $(signInButtonLocator);}
}
