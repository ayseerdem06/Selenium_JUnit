package tekrarDay10_Actions_Keyboards;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_KeyboardActions extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        /*
        facebook ana sayfaya gidip
        yeni kayıt oluştur butonuna basın
        isim kutusunu loacete edip geriye kalanları TAB ile dolaşarak formu doldurun
         */
        //facebook ana sayfaya gidip
        driver.get("https://www.facebook.com");

        // yeni kayıt oluştur butonuna basın
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //   isim kutusunu loacete edip geriye kalanları TAB ile dolaşarak formu doldurun
        WebElement isimKutusu=driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-']"));
        Actions actions = new Actions(driver);
        actions.click(isimKutusu).
                sendKeys("Ayse").
                sendKeys(Keys.TAB).
                sendKeys("Erdem").
                sendKeys(Keys.TAB).
                sendKeys("ayse@gmail.com").
                sendKeys(Keys.TAB).sendKeys("ayse@gmail.com").
                sendKeys(Keys.TAB).sendKeys("123").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("7").sendKeys(Keys.TAB).sendKeys("Ara").
                sendKeys(Keys.TAB).
                sendKeys("1982").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.LEFT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
    }
}
