package Odevler_Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev3_YanlisEmail {
     /*
    Bir Class olusturalim YanlisEmailTesti
    http://automationpractice.com/index.php sayfasina gidelim
    Sign in butonuna basalim
    Email kutusuna @isareti olmayan bir mail yazip enter’a
    bastigimizda “Invalid email address” uyarisi ciktigini test edelim
*/

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromiumdriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test(){
      //Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@class='login']")).click();
      //  Email kutusuna @isareti olmayan bir mail yazip enter’a
      WebElement emailKutusu= driver.findElement(By.xpath("(//*[@class='is_required validate account_input form-control'])[2]"));
      emailKutusu.sendKeys("ayseazra"+ Keys.ENTER);
     WebElement sonuc=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
     Assert.assertTrue(sonuc.isDisplayed());

    }

}
