package odevler_day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C04_Mause extends TestBaseBeforeAfter {

    /*
    Bir class oluşturalım
      1- https://www.amazon.com/ sayfasina gidelim
      2- Sağ Üst bölümde bulunan "Account & Lists" menusunun acilması için mause'u bu menunun üstüne getirelim
      3- "Create a list" butonuna basalım
      4- Açılan sayfada "Your Lists" yazisi olduğunu test edelim
     */

    @Test
    public void test1() {

        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //2- Sağ Üst bölümde bulunan "Account & Lists" menusunun acilması için mause'u bu menunun üstüne getirelim

       WebElement account= driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
       Actions actions = new Actions(driver);
       actions.moveToElement(account).perform();

       //3- "Create a list" butonuna basalım
       driver.findElement(By.xpath("//*[@class='nav-link nav-item'][1]")).click();

       //  4- Açılan sayfada "Your Lists" yazisi olduğunu test edelim
        WebElement yourListsYazisi=driver.findElement(By.xpath("//*[@role='heading']"));
        Assert.assertTrue(yourListsYazisi.isDisplayed());

    }
}
