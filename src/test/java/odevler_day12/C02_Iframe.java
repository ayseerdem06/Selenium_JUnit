package odevler_day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_Iframe extends TestBaseBeforeAfter {
    /*
    Ödev 2
   "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
   "Our Products" butonuna basin
   "Cameras product"i tiklayin
   Popup mesajini yazdirin
   "close" butonuna basin
   "WebdriverUniversity.com (IFrame)" linkini tiklayin
   "http://webdriveruniversity.com/index.html" adresine gittigini test edin

     */
    @Test
    public void test1() throws InterruptedException {
        // "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // "Our Products" butonuna basin
        WebElement iframe=driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
        Thread.sleep(2000);

        // "Cameras product"i tiklayin
        driver.findElement(By.xpath("//*[text()='Cameras']")).click();
        Thread.sleep(2000);

        //Popup mesajini yazdirin
        WebElement popupMesaji=driver.findElement(By.xpath("//*[@class='modal-body']"));
        System.out.println("Popup Mesaji :"+ popupMesaji.getText());

        //"close" butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();
        Thread.sleep(2000);


        // "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//*[@id='nav-title'])[1]")).click();

        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl="http://webdriveruniversity.com/index.html";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);



    }

}
