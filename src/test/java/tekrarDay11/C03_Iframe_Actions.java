package tekrarDay11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Iframe_Actions extends TestBaseBeforeAfter {
    /*
    Bir Class olusturalim KeyboardActions2
    2-https://html.com/tags/iframe/ sayfasina gidelim
    3- video’yu gorecek kadar asagi inin
    4-videoyu izlemek icin Play tusuna basin
    5-videoyu calistirdiginizi test edin

     */

    @Test
    public void test01() throws InterruptedException {

        // 2-https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

       // 3- video’yu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();


        //  4-videoyu izlemek icin Play tusuna basin
        WebElement ifmare=driver.findElement(By.xpath("//*[@width='560']"));
        driver.switchTo().frame(ifmare);
        WebElement video= driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        video.click();

        //  5-videoyu calistirdiginizi test edin
        WebElement duraklatButonu=driver.findElement(By.xpath("//*[@data-title-no-tooltip='Duraklat']"));
        Assert.assertTrue(duraklatButonu.isDisplayed());
        Thread.sleep(5000);
        duraklatButonu.click();




    }
}
