package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final By username = By.cssSelector("#login_field");
    private final By password = By.cssSelector("#password");
    private final By signInButton = By.cssSelector(".js-sign-in-button");

    public SelenideElement userName(){
        return $(username);
    }
    public SelenideElement password(){
        return $(password);
    }
    public SelenideElement signInButton(){
        return $(signInButton);
    }
}
