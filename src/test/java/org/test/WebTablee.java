package org.test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class WebTablee {
    @Test
    public void Sliders() {
        open("https://testautomationpractice.blogspot.com/");
        SelenideElement slider = $(By.id("slider-range")).scrollIntoView(true);
        sleep(3000);
//      SelenideElement sld= $x("//div[@class='ui-slider-range ui-corner-all ui-widget-header']");
//     actions().dragAndDropBy(sld,0,100).perform();
        SelenideElement bar1 = $x("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]");
        SelenideElement bar2 = $x("//div[@id='HTML7']//span[2]");
//        actions().dragAndDropBy(bar1, 0, 0).perform(); // reset to far left
//        actions().dragAndDropBy(bar2, 0, 0).perform();

        actions().dragAndDropBy(bar1, 15, 0).perform();
        actions().dragAndDropBy(bar2, 59, 0).perform();
        sleep(2000);
        String text = $x("//input[@id='amount']").getValue();
        System.out.println(text);
        sleep(3000);
    }

    @Test
    public void webtable() {
        open("https://testautomationpractice.blogspot.com/");
        $x(" (//tr)[1]").scrollIntoView(true);
        // SelenideElement tr= $x(" (//tr)[1]");
        SelenideElement table = $x("//table[@name='BookTable']");
        ElementsCollection rows= table.$$(By.cssSelector("tbody tr"));
        int size = rows.size();
        for(SelenideElement row : rows){
          ElementsCollection column=  row.$$(By.tagName("td"));
          int text=column.size();
            System.out.println(text);
         SelenideElement seccol= column.get(0);
         String text1=seccol.getText();
            System.out.println(text1);

        }




    }


}
