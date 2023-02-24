package tests;

import baseEntities.BaseTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SimpleTest extends BaseTest {


    @Test
    public void test() throws InterruptedException {
        open("/");
        mainPage.getSignIn().click();
        Thread.sleep(4000);
    }
}
