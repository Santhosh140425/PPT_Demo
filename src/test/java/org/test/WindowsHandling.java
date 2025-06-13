package org.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Set;

import static com.codeborne.selenide.Selenide.*;

public class WindowsHandling {
    @Test
    public void windowhandle() {

        open("https://www.globalsqa.com/demo-site/frames-and-windows/");
        $x("(//a[text()='Click Here'])[1]").click();
        WebDriver driver = WebDriverRunner.getWebDriver();
        String parent = driver.getWindowHandle();
        Set<String> allwindows = driver.getWindowHandles();
        for (String window : allwindows) {
            if (!window.equals(parent)) {
                driver.switchTo().window(window);
                break;
            }
        }
        $x("(//a[text()='Click Here'])[1]").click();
        String text = $x("(//h1[text()='Frames And Windows'])[1]").getText();
        $x("(//h1[text()='Frames And Windows'])[1]").shouldHave(Condition.text(text));
        System.out.println(text);

    }
}
