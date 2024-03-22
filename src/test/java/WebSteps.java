import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    // в параметрах аннотации '@Step' можно указать передаваенмый параметр для теста
    // @Step("Открываем главную страницу {param}")

    @Step("Открываем главную страницу Яндекс")
    public void openMainPage(){
        open("https://ya.ru/");
    }

    @Step("Кликаем по полю поиска")
    public void clickOnSearchField(){
        $("#text").click();
    }

    @Step("Вводим данные в поле поиска")
    public void enterDataInSearchField(){
        $("#text").setValue("selenide");
    }

    @Step("Кликаем по кнопке 'Найти'")
    public void clickOnSearchButton(){
        $("button[type='submit']").click();
    }

    @Step("Проверяем отображение списка найденных элементов")
    public void checkListOfFoundItems(){
        $("ul#search-result").should(exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
