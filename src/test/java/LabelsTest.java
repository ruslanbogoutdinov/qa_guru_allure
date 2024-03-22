import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
    // BDD - Behaviour Driven Development
    // название подхода - автотесты как документация
    // рекомендуемый подход
    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("ruslanbogoutdinov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание Issue для авторизированного пользователя")
    void testStaticLabels(){

    }

    // альтернативный подход
    // используется для точек расширения фреймворка (JUnit5 и тд)
    @Test
    void testDynamicLabels(){
       Allure.getLifecycle().updateTestCase(
               t -> t.setName("Создание Issue для авторизированного пользователя")
       );
       Allure.feature("Issue в репозитории");
       Allure.story("Создание Issue");
       Allure.label("owner", "ruslanbogoutdinov");
       Allure.label("severity", SeverityLevel.BLOCKER.value());
       Allure.link("link", "https://testing.github.com");
    }
}
