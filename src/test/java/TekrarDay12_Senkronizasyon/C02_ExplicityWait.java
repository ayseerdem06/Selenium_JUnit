package TekrarDay12_Senkronizasyon;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C02_ExplicityWait extends TestBaseBeforeAfter {
    /*
    // Bir method oluşturun : isEnabled()
    // https://the-internet.herokuapp.com/dynamic_controls adresine gidin
    // Textbok'ıın etkin olmadığını doğrulayın
    // Enable butonuna tıklayın ve txtbox etkin oluncaya kadar bekleyin.
    // "It's enabled!" mesajının görüntülendiğini doğrulayın
    // Textbox'ın etkin olduğunu doğrulayın
    */

    @Test
    public void isEnabledTest1(){
        // https://the-internet.herokuapp.com/dynamic_controls adresine gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Textbok'ıın etkin olmadığını doğrulayın
        WebElement texbox=driver.findElement(By.xpath("//*[@type='text']"));
        Assert.assertFalse(texbox.isEnabled());

        // Enable butonuna tıklayın ve txtbox etkin oluncaya kadar bekleyin.
        driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
        WebDriverWait  wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(texbox));

        //  // "It's enabled!" mesajının görüntülendiğini doğrulayın
        WebElement yaziElementi= driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(yaziElementi.isDisplayed());

        // Textbox'ın etkin olduğunu doğrulayın
        Assert.assertTrue(texbox.isEnabled());



       

    }
}
