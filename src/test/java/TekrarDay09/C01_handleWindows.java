package TekrarDay09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {


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
       // driver.close();
    }

    @Test
    public void test01(){
        // 1- Amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        // Nutella için arama yaptırın
         driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);


        /*
         sayfanın hash kodunu handle değerini getirir.
         Selenium sayfalar arası geçişte bu window handle değerimi kullanır
         Eğer sayfalar arasında driver'iımızı gezdiriyorsak ve herhangi bir sayfadan sonra
         bulunduğumuz sayfaya geçmek istersen driver.switch.To().window("CDwindow-987D769BE69191298B51D01D480F188C");
         bu sayfanın handle değerini girerek bu sayfaya geçiş yaparız

         */


        // 3- ilk urunun resmini tıklayarak farklı bir tab olarak açın
        WebElement ilkUrunResmi=driver.findElement(By.xpath("//*[@class='a-section aok-relative s-image-square-aspect'][1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("//*[@class='a-section aok-relative s-image-square-aspect'][1]")).click();


        // 4- yeni tab'da açılan urunun fiyatını yazdırın
       // WebElement urunFiyat=driver.findElement(By.xpath("//*[@class='a-price-whole'][1]"));
        //System.out.println(urunFiyat.getText());

    }
}
