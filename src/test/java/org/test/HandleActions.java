package org.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class HandleActions {
    @Test
    public void mouseoverActions() {
        open("https://demoqa.com/menu");
        $x("//a[text()='Main Item 2']").scrollTo();
        sleep(2000);
        $x("//a[text()='Main Item 2']").hover();
        sleep(2000);
    //    $x("//a[text()='SUB SUB LIST »']").scrollTo();
        $x("//a[text()='SUB SUB LIST »']").hover();
        String text = $x("//a[text()='Sub Sub Item 1']").getText();
        $x("//a[text()='Sub Sub Item 1']").shouldHave(Condition.text(text));
        $x("//a[text()='Sub Sub Item 1']").click();
        System.out.println(text);
    }

    @Test
    public void DifferentClicks() {
        open("https://demoqa.com/buttons");
        $x("//button[text()='Click Me']").scrollTo();
        $x("//button[text()='Double Click Me']").doubleClick();
        $x("//button[text()='Right Click Me']").contextClick();
        sleep(2000);
    }
}
