package baseEntities;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import configuration.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import models.Repository;
import models.User;
import org.testng.annotations.*;
import steps.NavigationSteps;
import steps.RepositorySteps;
import steps.UserSteps;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected NavigationSteps navigationSteps;
    protected RepositorySteps repositorySteps;
    protected UserSteps userSteps;
    protected Repository repository;
    protected User user;
    protected Faker faker;
    protected String textForDeletion;

    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        navigationSteps = new NavigationSteps();
        repositorySteps = new RepositorySteps();
        userSteps = new UserSteps();
        faker = new Faker();

        Configuration.browser = ReadProperties.browserName();
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.timeout = 15000;
        Configuration.fastSetValue = false;

        open("/");

        user = User.builder()
                .name(ReadProperties.username())
                .password(ReadProperties.password())
                .build();

        repository = Repository.builder()
                .name(faker.beer().name().replaceAll(" ", ""))
                .description(faker.beer().name())
                .build();
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}
