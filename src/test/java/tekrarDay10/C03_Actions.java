package tekrarDay10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {
     /*
    Yeni bir class olusturalim: MouseActions2
    1-https://demoqa.com/droppable adresine gidelim
    2-“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    3-“Drop here” yazisi yerine “Dropped!” oldugunu test edin
     */

    @Test
    public void test1() {
        //1-https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //  2-“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragElement=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropElement= driver.findElement(By.xpath("//*[@id='droppable'][1]"));
        actions.dragAndDrop(dragElement,dropElement).perform();

        //3-“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//*[text()='Dropped!']"));;
        String expectedYazi="Dropped!";
        String actualYazi=sonucYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);



    }
}
