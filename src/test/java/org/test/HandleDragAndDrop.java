package org.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class HandleDragAndDrop {
    @Test
    public void DragAndDrop() {
        open("https://ui.vision/demo/webtest/dragdrop/");
        sleep(4000);
        SelenideElement dragElement1 = $x("//a[text()='one']");
        SelenideElement dragElement2 = $x("//a[text()='two']");
        SelenideElement dragElement3 = $x("//a[text()='three']");
        SelenideElement dropElement = $(By.id("bin"));

        actions().dragAndDrop(dragElement1, dropElement).perform();
        sleep(2000);
        actions().dragAndDrop(dragElement2, dropElement).perform();
        sleep(1000);
        actions().dragAndDrop(dragElement3, dropElement).perform();
        sleep(1000);


        dropElement.should(Condition.visible);
        String a = dropElement.getText();
        System.out.println(a);
        sleep(3000);
    }

}
