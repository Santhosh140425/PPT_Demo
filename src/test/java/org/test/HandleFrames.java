package org.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class HandleFrames {
    @Test
    public void Frames() {

        //Parent frame
        open("https://ui.vision/demo/webtest/frames/");
        switchTo().frame(0);
        SelenideElement sa = $x("(//input[@type='text'])[1]").setValue("santhosh");
        sa.shouldHave(value("santhosh"));
        System.out.println(sa.getValue());
        switchTo().defaultContent();

        //Child frame with Inner frame

        switchTo().frame(2);
        $x("//input[@name='mytext3']").setValue("udhayakumar").shouldHave(value("udhayakumar"));
        sleep(3000);
        switchTo().frame(0);
        $x("(//div[@class='AB7Lab Id5V1'])[2]").click();
        $x("//span[text()='Web Testing']").scrollTo().click();
        $x("//span[text()='Next']").scrollTo().click();
        $x("//span[text()='Submit']").scrollTo().click();
        String text = $x("//div[@class='vHW8K']").getText();
        System.out.println(text);


    }


}
