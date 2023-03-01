package tests.data;

import models.Repository;
import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Condition.disabled;


public class StaticProvider {
    @DataProvider(name = "dataForLimitValuesTest")
    public static Object[][] dataForLimitValuesTest() {
        return new Object[][]{
                {"", disabled},
                {"", disabled},
                {"", disabled}
        };
    }
}
