package practice_dersi01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LoginTest {

    //1- https://www.koalaresorthotels.com/ sayfasına gidin

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void test(){
        //1- https://www.koalaresorthotels.com/ sayfasına gidin
        driver.get("https://www.koalaresorthotels.com/");

        // 2- Login butonuna tıkla
        driver.findElement(By.xpath("//*[text()='Log in']")).click();

        // Log in ekranına girdiğinizi 4 farklı Webelement kullanaraj doğrulayınız
        //I-
        String expectedUrl="https://www.koalaresorthotels.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("Login ekranına giriş yapılmadı",expectedUrl,actualUrl);

        // II-
        Assert.assertTrue(driver.getTitle().contains("Login in"));

    }

}
