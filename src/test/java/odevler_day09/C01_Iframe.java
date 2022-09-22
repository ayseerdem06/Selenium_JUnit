package odevler_day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C01_Iframe {
    /*
    Bir class olusturun: IframeTest02
    http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    sayfadaki iframe sayısını bulunuz.
    ilk iframe'deki (Youtube) play butonuna tıklayınız.
    ilk iframe'den çıkıp ana sayfaya dönünüz
    ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
    tıklayınız
     */

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        // driver.close();

    }

    @Test
    public void test01() throws InterruptedException {

        // http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        System.out.println("Iframe sayisi : "+ iframeList.size());

        // ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@width='560']")));  // once iframe ın tamamını locate ettim
        WebElement youtube=driver.findElement(By.xpath("//*[@aria-label='Oynat']"));   // play tusu locate edildi ve click lendi
        youtube.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='ytp-play-button ytp-button']")).click(); // youtube videosunu durdurdum


        //ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        // ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //    tıklayınız
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='a077aa5e']")));   // iframe geçmek için önce locate ettim
        driver.findElement(By.xpath("//*[@src='Jmeter720.png']")).click();





    }

}
