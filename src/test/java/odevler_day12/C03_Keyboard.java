package odevler_day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Keyboard extends TestBaseBeforeAfter {
    /*
    Ödev 1

    "http://webdriveruniversity.com/Actions" sayfasina gidin
    "Hover over Me First" kutusunun ustune gelin
    "Link 1" e tiklayin
    Popup mesajini yazdirin
    Popup'i tamam diyerek kapatin
    "Click and hold" kutusuna basili tutun
    "Click and hold" kutusunda cikan yaziyi yazdirin
    "Double click me" butonunu cift tiklayin
         */

    @Test
    public void test01() throws InterruptedException {
        // "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // "Hover over Me First" kutusunun ustune gelin
        WebElement hover= driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hover);
        Thread.sleep(2000);

        //  "Link 1" e tiklayin

        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

        // Popup mesajini yazdirin
        Thread.sleep(2000);
        System.out.println("Popup Mesaji :"+ driver.switchTo().alert().getText());

        //Popup'i tamam diyerek kapatin
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // "Click and hold" kutusuna basili tutun
        WebElement click=driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        actions.clickAndHold(click);



    }
}
