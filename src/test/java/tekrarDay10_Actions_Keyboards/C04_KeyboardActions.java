package tekrarDay10_Actions_Keyboards;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C04_KeyboardActions extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        /*
        Amazona gidelim
        Once arama  kutusuna click yapıp sonra harf Nutella yazisini yazdıralım
        Sonra Enter tuşuna basalım
         */

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.click(aramaKutusu).
                keyDown(Keys.SHIFT).
                sendKeys("n").
                keyUp(Keys.SHIFT).
                sendKeys("u").
                sendKeys("t").
                sendKeys("e").
                sendKeys("l").
                sendKeys("l").
                sendKeys("a").
                sendKeys(Keys.ENTER).perform();

    }
}
