package tekrarDay09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBaseBeforeAfter;

public class C02_Amazon_BestBuy extends TestBaseBeforeAfter {

    /*
    //1- Amazon Sayfasina girelim
    //2- Url'nin amazon içerdiğini test edelim
    //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
    //4- title'in Best Buy içerdiğini test edelim
    //5- İlk sayfaya dönüp sayfada java aratalım
    //6- Arama sonuclarının java içerdiğini test edelim
    //7- Yeniden bestbuy sayfasına gidelim
    //8- Logonun görünürlüğünü test edelim
    //9- Sayfaları Kapatalım

     */

    @Test
    public void test1() throws InterruptedException {
        // //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazon=driver.getWindowHandle();

        // //2- Url'nin amazon içerdiğini test edelim
        String expectedUrl="amazon";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //  //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuy=driver.getWindowHandle();

        // //4- title'in Best Buy içerdiğini test edelim
        String expectedTitle="Best Buy";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //5- İlk sayfaya dönüp sayfada java aratalım
        Thread.sleep(2000);
        driver.switchTo().window(amazon);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java"+ Keys.ENTER);

        // 6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananKelime="java";
        String actualText=aramaSonucu.getText();
        Assert.assertTrue(actualText.contains(arananKelime));

        // 7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuy);

        //8- Logonun görünürlüğünü test edelim
        Thread.sleep(2000);
        WebElement logo = driver.findElement(By.xpath("//*[@class='logo'][1]"));
        Assert.assertTrue(logo.isDisplayed());

        //9- Sayfaları Kapatalım
        Thread.sleep(2000);
        driver.quit();


    }
}
