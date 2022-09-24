package tekrarDay10_Actions_Keyboards;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C02_Actions extends TestBaseBeforeAfter {

    /*
        1-Yeni bir class olusturalim: MouseActions1
        2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
        3- Cizili alan uzerinde sag click yapalim
        4-Alert’te cikan yazinin “You selected a context menu” oldugunu
        test edelim.
        5-Tamam diyerek alert’i kapatalim
        6-Elemental Selenium linkine tiklayalim
        7-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
         */

    @Test
    public void test1() {
        //  2-https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapalim
        Actions actions= new Actions(driver);
        WebElement cigiElementi=driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(cigiElementi).perform();

        // 4-Alert’te cikan yazinin “You selected a context menu” oldugunu
        //        test edelim.
        String expectedYazi = "You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        // 5-Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //  6-Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        List<String> sayfalar=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(sayfalar.get(1));

        //  //7-Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
       Assert.assertEquals("Elemental Selenium",driver.findElement(By.xpath("//h1")).getText());





    }
}
