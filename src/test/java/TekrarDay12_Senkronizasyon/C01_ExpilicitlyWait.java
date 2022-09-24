package TekrarDay12_Senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C01_ExpilicitlyWait extends TestBaseBeforeAfter {


        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        //Remove butonuna basin.
        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        //Add buttonuna basin
        //It’s back mesajinin gorundugunu test edin


    @Test
    public void implicitWaitTest(){
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // //Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement yaziElementi=driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(yaziElementi.isDisplayed());
        
        //  //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // //It’s back mesajinin gorundugunu test edin
        WebElement mesajYazisi=driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(mesajYazisi.isDisplayed());
    }

    @Test
    public void expilicitliWaitTest(){

        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // //Remove butonuna basin.
        driver.findElement(By.xpath("//*[@onclick='swapCheckbox()']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement yaziElementi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(yaziElementi.isDisplayed());

        //  //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // //It’s back mesajinin gorundugunu test edin
        WebElement mesajYazisi=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(mesajYazisi.isDisplayed());

    }

}
