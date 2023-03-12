package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement userNameInputLocator = $("#login_field");
    private final SelenideElement passwordInputLocator = $("#password");
    private final SelenideElement loginButtonLocator = $(By.className("js-sign-in-button"));
    private final SelenideElement incorrectLoginLocator = $(By.className("js-flash-alert"));

    public SelenideElement getUserNameInputLocator() {
        return userNameInputLocator;
    }

    public SelenideElement getPasswordInputLocator() {
        return passwordInputLocator;
    }

    public SelenideElement getLoginButtonLocator() {
        return loginButtonLocator;
    }

    public SelenideElement getIncorrectLoginLocator() {
        return incorrectLoginLocator.shouldBe(visible);
    }
}