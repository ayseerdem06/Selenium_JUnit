package tekrarDay07_DorpDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin
    3 farklı test methodu oluşturarak aşağıdaki görevleri yapın
    1- URL'nin amazon içerdiğini test edin
    2- Title'in facebook içermediğini test edin
    3- sol üst köşede amazon logosunun göründüğünü test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public  void test01(){
        // 1- URL'nin amazon içerdiğini test edin
        String expectedUrl="amazon";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }

    @Test
    public void test02(){
      //  2- Title'in facebook içermediğini test edin
      String istenmeyenKelime="facebook";
      String actualTitle=driver.getTitle();
      Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }

    @Test
    public void tes03(){
        WebElement logoElementi=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
}
