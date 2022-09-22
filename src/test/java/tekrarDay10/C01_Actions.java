package tekrarDay10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {

    /*
    amzon anasayfasına gidip
    account  menüsünden create a list linkine tıklayalım
     */

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement accountLink=driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        actions.moveToElement(accountLink).perform();
        driver.findElement(By.xpath("(//*[@class='nav-link nav-item'])[1]")).click();
        Thread.sleep(2000);


    }
}
