package odevler_day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C02 extends TestBaseBeforeAfter {

    /*
    Bir Class olusturalim KeyboardActions2
    2-https://html.com/tags/iframe/ sayfasina gidelim
    3- video’yu gorecek kadar asagi inin
    4-videoyu izlemek icin Play tusuna basin
    5-videoyu calistirdiginizi test edin

     */

    @Test
    public void test1() throws InterruptedException {
        //2-https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // 3- video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        List<WebElement> iframe= new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframe.get(0));
       WebElement video= driver.findElement(By.xpath("//*[@aria-label='Oynat']"));

      //  4-videoyu izlemek icin Play tusuna basin
       video.click();

       //  5-videoyu calistirdiginizi test edin
        WebElement duraklatButonu=driver.findElement(By.xpath("//*[@title='Duraklat (k)']"));   // duraklatarak test ettim
        Assert.assertTrue(duraklatButonu.isDisplayed());
        Thread.sleep(4000);
        duraklatButonu.click();   // duraklat butonunu durdurdum

    }
}
