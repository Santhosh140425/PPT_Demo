package org.test;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Multiple_Allerts {
    @Test(priority = 0)
    public void smipleAlert() {
        open("https://demo.automationtesting.in/Alerts.html");
        $x("(//a[@class='analystic'])[1]").click();
        $x("//button[@class='btn btn-danger']").click();
        sleep(2000);
        Alert Alertmessage = switchTo().alert();
        String text = Alertmessage.getText();
        System.out.println(text);
        switchTo().alert().accept();
    }

    @Test(priority = 1)
    public void confirmAlert() {
        open("https://demo.automationtesting.in/Alerts.html");
        $x("(//a[@class='analystic'])[2]").click();
        $x("//button[@class='btn btn-primary']").click();
        Alert Alertmessage = switchTo().alert();
        String text = Alertmessage.getText();
        System.out.println(text);
        sleep(3000);
        switchTo().alert().dismiss();
    }

    @Test(priority = 2)
    public void promtAlert() {
        open("https://demo.automationtesting.in/Alerts.html");
        $x("(//a[@class='analystic'])[3]").click();
        $x("//button[@class='btn btn-info']").click();
        Alert send = switchTo().alert();
        send.sendKeys("santhosh");
        sleep(4000);
        send.accept();
       String text= $x("//p[@id='demo1']").getText();
        $x("//p[@id='demo1']").shouldHave(Condition.text(text));
        System.out.println(text);
    }

}
