package day06;

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
public class C02_Assertion {
    /*
    - Amazon sayfasına gidelim
    3 farklı test methodu oluşturalım
      a-Url'nin amazon içerdiğini test edelim
      b-Title'in facebook içermediğini test edelim
      c- sol üst köşede amazon logosunun göründüğünü test edelim
      d- Url'nin www.facebook.com olduğunu test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
    @Test
    public void test1(){
        //a-Url'nin facebook içerdiğini test edelim
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertFalse(actualUrl.contains(expectedUrl));
        //Assert.assertNotEquals(expectedUrl,actualUrl);
    }
    @Test
    public void test2(){
        //b-Title'in facebook içermediğini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
        //c- sol üst köşede amazon logosunun göründüğünü test edelim
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4(){
        //d- Url'nin www.facebook.com olduğunu test edin
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
    }
}
