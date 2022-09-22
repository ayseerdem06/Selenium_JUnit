package odevler_day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_Zero {

    /*
    1. http://zero.webappsecurity.com/ Adresine gidin
    2. Sign in butonuna basin
    3. Login kutusuna “username” yazin
    4. Password kutusuna “password.” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
    9. “amount” kutusuna bir sayi girin
    10. “US Dollars” in secilmedigini test edin
    11. “Selected currency” butonunu secin
    12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */

    WebDriver driver;

    @Before
    public void setup(){

    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@class='signin btn btn-info']")).click();

        //3. Login kutusuna “username” yazin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

        //4. Password kutusuna “password.” yazin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");

        //5. Sign in tusuna basin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='submit']")).click();

        // guvenli sayfa uyarısı verdiği için geri gelmemiz lazım
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='searchTerm']")).sendKeys("Pay Bills"+ Keys.ENTER);
        driver.findElement(By.xpath("//*[text()='Zero - Pay Bills']")).click();

        //7. “Purchase Foreign Currency” tusuna basin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        Thread.sleep(1000);
        WebElement ddm=driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select=new Select(ddm);
        select.selectByValue("EUR");

        // 9. “amount” kutusuna bir sayi girin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("123");

        //10. “US Dollars” in secilmedigini test edin
        Thread.sleep(1000);
        WebElement usDolar= driver.findElement(By.xpath("//*[@class='radio inline'][2]"));
        Assert.assertFalse(usDolar.isSelected());

        // 11. “Selected currency” butonunu secin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='radio inline'][3]")).click();

        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='purchase_cash']")).click();

        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        Thread.sleep(1000);
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@id='alert_content']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());



    }

}
