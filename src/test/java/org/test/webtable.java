import static com.codeborne.selenide.Selenide.*;import static com.codeborne.selenide.Condition.*;import com.codeborne.selenide.ElementsCollection;import com.codeborne.selenide.SelenideElement;import org.openqa.selenium.By;import org.testng.annotations.Test;public class table{




    @Test    public void test() {        open("https://testautomationpractice.blogspot.com/");        SelenideElement table = $("table[name='BookTable']");
    table.scrollIntoView(true);
    ElementsCollection rows = table.$$("tr");        // Skip header row by starting from index 1        for (int i = 1; i < rows.size(); i++) {            ElementsCollection columns = rows.get(i).$$("td");            String bookName = columns.get(0).getText();            String author = columns.get(1).getText();            String subject = columns.get(2).getText();            String price = columns.get(3).getText();            System.out.println("Row " + i + ": " + bookName + " | " + author + " | " + subject + " | " + price);            if (author.equals("Mukesh")) {                System.out.println("✅ Found Mukesh as the author of book: " + bookName);                break;            }        }    }}