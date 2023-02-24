package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import pages.MainPage;


import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    public MainPage mainPage;

    @BeforeSuite
    public void setUp() {

        mainPage = new MainPage();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 15000;
        Configuration.fastSetValue = false;
//        Configuration.assertionMode = AssertionMode.SOFT;
//        Configuration.headless = true;
//        Configuration.reportsFolder = "target/";
    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }
}
