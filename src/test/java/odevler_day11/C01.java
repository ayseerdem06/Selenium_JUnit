package odevler_day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01 extends TestBaseBeforeAfter {
    /*
    Yeni Class olusturun ActionsClassHomeWork
   1- "http://webdriveruniversity.com/Actions" sayfasina gidin
   2- Hover over Me First" kutusunun ustune gelin
   3-Link 1" e tiklayin
   4-Popup mesajini yazdirin
   5-Popup'i tamam diyerek kapatin
   6-"Click and hold" kutusuna basili tutun
   7-"Click and hold" kutusunda cikan yaziyi yazdirin
   8- "Double click me" butonunu cift tiklayin
     */

    @Test
    public void test1() {

        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hover=driver.findElement(By.xpath("//*[text()='Hover Over Me First!']"));
        actions.moveToElement(hover).perform();

        //3-Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

        //4-Popup mesajini yazdirin
        System.out.println("Poput mesaji:"+ driver.switchTo().alert().getText());

        // 5-Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6-"Click and hold" kutusuna basili tutun
        WebElement hold= driver.findElement(By.xpath("//*[text()='Click and Hold!']"));
        actions.clickAndHold(hold).perform();

        //7-"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Elemente tiklayinca cikan mesaj: "+ driver.findElement(By.xpath("//*[@id='click-box']")).getText());

        // 8- "Double click me" butonunu cift tiklayin
        WebElement doubleME=driver.findElement(By.xpath("//*[text()='Double Click Me!']"));
        actions.doubleClick(doubleME).perform();
        


    }
}
