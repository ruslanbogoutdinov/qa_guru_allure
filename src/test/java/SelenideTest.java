import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    void yandexSearchFieldTest(){
        // выводим полный test body в allure отчете
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://ya.ru/");

        $("#text").click();
        $("#text").setValue("selenide");
        $("button[type='submit']").click();
        $("ul#search-result").should(exist);
    }
}
