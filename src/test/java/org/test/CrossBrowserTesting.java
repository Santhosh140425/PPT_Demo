package org.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class CrossBrowserTesting {
    @Test
    public void Browsers() {
          Configuration.browser = "chrome";
        open("https://practicetestautomation.com/practice-test-login/");
        $(By.id("username")).setValue("student");
        sleep(2000);
        $(By.id("password")).setValue("Password123");
        sleep(1000);
        $(By.id("submit")).click();
        sleep(2000);
        String text = $x("//strong[text()='Congratulations student. You successfully logged in!']").getText();
        $x("//strong[text()='Congratulations student. You successfully logged in!']").shouldHave(Condition.text(text));
        System.out.println(text);
        sleep(1000);
        $x("//a[text()='Log out']").click();
        sleep(1000);
        $x("//h2[text()='Test login']").shouldBe(Condition.visible);

    }

}
