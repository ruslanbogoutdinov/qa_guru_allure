import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {
    @Test
    void yandexSearchFieldLambdaTest(){
        // выводим полный test body в allure отчете
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную старницу Яндекс", ()->{
            open("https://ya.ru/");
            attachment("Source", webdriver().driver().source());
        });

    }

    // такой подход хорош для переиспользования степов
    @Test
    void yandexSearchFieldAnnotatedTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.takeScreenshot();
    }
}
