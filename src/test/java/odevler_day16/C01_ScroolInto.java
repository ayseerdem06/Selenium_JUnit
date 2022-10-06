package odevler_day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class C01_ScroolInto extends TestBaseBeforeAfter {

    /*
    Yeni bir class olusturun : ScroolInto
    hotelmycamp anasayfasina gidin ("https://hotelmycamp.com")
    2 farkli test method’u olusturarak actions classi ve
    Js Executor kullanarak asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
    istediginiz oda inceleme sayfasi acildigini test  edin
     */

    @Test
    public void test01() {

        //  hotelmycamp anasayfasina gidin ("https://hotelmycamp.com")
        driver.get("https://hotelmycamp.com");
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
       // driver.findElement(By.xpath("//select[@id='IDRoomType']");

    }
}
