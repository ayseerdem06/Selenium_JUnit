package odevler_day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C01_LoginPortal extends TestBaseBeforeAfter {

    /*
    1."http://webdriveruniversity.com/" adresine gidin
    2."Login Portal" a  kadar asagi inin
    3."Login Portal" a tiklayin
    4.Diger window'a gecin
    5."username" ve  "password" kutularina deger yazdirin
    6."login" butonuna basin
    7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
    8.Ok diyerek Popup'i kapatin
    9-Ilk sayfaya geri donun
    10-Ilk sayfaya donuldugunu test edin

     */

    @Test
    public void test1() throws InterruptedException {

        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        // 2."Login Portal" a  kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();

        //  4.Diger window'a gecin
        List<String> windowHandle=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandle.get(1));

        //  5."username" ve  "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("Eda");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123");

        // 6."login" butonuna basin
        driver.findElement(By.xpath("//*[@id='login-button']")).click();

        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedYazi="validation failed";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertTrue(actualYazi.contains(expectedYazi));

        // 8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        // 9-Ilk sayfaya geri donun
        driver.switchTo().window(windowHandle.get(0));

        // 10-Ilk sayfaya donuldugunu test edin
        String expectedUrl="http://webdriveruniversity.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);



    }
}
