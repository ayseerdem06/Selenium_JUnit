package day05_BeforeAfter_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {

    WebDriver driver;
    /*
    Before notasyonu her testten önce çalışır
    After notasyonu her testten sonra çalışır
    After Before un koyulduğu yer farketmez
    */


    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public  void method1(){
        // 1 defa before methodu çalışır
        driver.get("https://www.amazon.com");
        // 1 defa after methodu çalışır

    }
    @Test
    public  void method2(){
        // 1 defa before methodu çalışır
        driver.get("https://www.techproeducation.com");
        // 1 defa after methodu çalışır

    }
    @Test
    public  void method3(){
        // 1 defa before methodu çalışır
        driver.get("https://www.hepsiburada.com");
        // 1 defa after methodu çalışır

    }


    @After
    public void tearDown(){
        driver.close();
    }

}
