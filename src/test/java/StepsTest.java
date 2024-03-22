import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepsTest {
    @Test
    void yandexSearchFieldLambdaTest(){
        // выводим полный test body в allure отчете
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную старницу Яндекс", ()->{
            open("https://ya.ru/");
        });
        step("Кликаем по полю поиска", ()->{
            $("#text").click();
        });
        step("Вводим данные в поле поиска", ()->{
            $("#text").setValue("selenide");
        });
        step("Кликаем по кнопке 'Найти'", ()->{
            $("button[type='submit']").click();
        });
        /*step("Проверяем отображение списка найденных элементов", ()->{
            $("ul#search-result").should(exist);
        });*/
    }

    // такой подход хорош для переиспользования степов
    @Test
    void yandexSearchFieldAnnotatedTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.clickOnSearchField();
        steps.enterDataInSearchField();
        steps.clickOnSearchButton();
        //steps.checkListOfFoundItems();
        //steps.checkListOfFoundItems();
    }
}
