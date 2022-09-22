package day08_Alert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {

    /*
    - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    - Click for js Alert butonuna tıklayalım
    - Tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
     */

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        // - https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //   - Tıkladıktan sonra çıkan uyarı mesajına (alerte) tamam diyelim
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    }


}
