package org.test;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class Download_upload_File {

    @Test(priority = 1)
    public void uploadFile() {

        open("https://practice.expandtesting.com/upload");
        String filePath = "src/test/Files/sandy.png";
        sleep(2000);
        $(By.id("fileInput")).uploadFile(new File(filePath));
        $(By.className("my-link")).scrollTo();
        sleep(2000);
        $(By.id("fileSubmit")).click();
        String successMessage = $x("//h1[text()='File Uploaded!']").getText();
        $x("//h1[text()='File Uploaded!']").should(Condition.text(successMessage));
        System.out.println(successMessage);
    }

    @Test(priority = 2)
    public void downloadFile() throws InterruptedException {
        open("https://practice.expandtesting.com/download");
        $x("//li[normalize-space()='cdct.jpg']").scrollTo();
        sleep(2000);
        $x("(//div[@class='d-flex mb-2'])[1]").click();
        sleep(3000);
    }


}
