import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TestP24 {
    @Test
    public void firstTest() {
        WebDriverManager.chromedriver().setup();

        Selenide.open("https://next.privat24.ua/money-transfer/card");

        Selenide.$(By.cssSelector("input[data-qa-node='numberdebitSource']")).sendKeys("4552331448138217");
        Selenide.$(By.cssSelector("input[data-qa-node='expiredebitSource']")).sendKeys("05/24");
        Selenide.$(By.cssSelector("input[data-qa-node='cvvdebitSource']")).sendKeys("926");
        Selenide.$(By.cssSelector("input[data-qa-node='firstNamedebitSource']")).sendKeys("IVAN");
        Selenide.$(By.cssSelector("input[data-qa-node='lastNamedebitSource']")).sendKeys("IVANOV");
        Selenide.$(By.cssSelector("input[data-qa-node='numberreceiver']")).sendKeys("4004159115449003");
        Selenide.$(By.cssSelector("input[data-qa-node='firstNamereceiver']")).sendKeys("PETRO");
        Selenide.$(By.cssSelector("input[data-qa-node='lastNamereceiver']")).sendKeys("PETROV");
        Selenide.$(By.cssSelector("input[data-qa-node='amount']")).sendKeys("123");
        Selenide.$(By.cssSelector("button[data-qa-node='currency']")).click();
        Selenide.$(By.cssSelector("button[data-qa-value='USD']")).click();

        Selenide.$(By.cssSelector("button[class=\"sc-VigVT eHZYiI\"]")).click();

        Selenide.$(By.cssSelector("span[data-qa-node='payer-card']")).shouldHave(Condition.text("4552 3314 4813 8217"));
        Selenide.$(By.cssSelector("div[data-qa-node='receiver-name']")).shouldHave(Condition.text("PETRO PETROV"));
        Selenide.$(By.cssSelector("span[data-qa-node='receiver-card']")).shouldHave(Condition.text("4004 1591 1544 9003"));
        Selenide.$(By.cssSelector("div[data-qa-node='payer-amount']")).shouldHave(Condition.text("123 USD"));
        Selenide.$(By.cssSelector("div[data-qa-node='payer-currency']")).shouldHave(Condition.text("5.41 USD"));
        Selenide.$(By.cssSelector("div[data-qa-node='receiver-amount']")).shouldHave(Condition.text("123 USD"));
        Selenide.$(By.cssSelector("div[data-qa-node='receiver-currency']")).shouldHave(Condition.text("0 USD"));
        Selenide.$(By.cssSelector("div[class=\"sc-chPdSV iiqwfv\"]")).shouldHave(Condition.text("128.41 USD"));

    }
}

