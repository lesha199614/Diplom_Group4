package pages.repository;

import com.codeborne.selenide.SelenideElement;
import models.Collaborator;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ListRepositoriesPage {

    private final SelenideElement textAboutDeleteRepository = $(By.xpath
            ("//div[contains( text(), 'successfully deleted')]"));
    List<SelenideElement> repos = $$(By.xpath("//*[@id=\"user-repositories-list\"]//a"));


    public SelenideElement getTextAboutDeleteRepository() {
        return textAboutDeleteRepository;
    }


    public List<SelenideElement> repos() {
        return repos;
    }
}
