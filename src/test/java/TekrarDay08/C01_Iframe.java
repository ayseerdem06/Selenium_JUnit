package TekrarDay08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {

    /*
    . https://the-internet.herokuapp.com/iframe  adresine gidin
    . Bir method oluşturun iframeTest
    - "An IFrame containing..."textinin erişilebilir olduğunu test edin ve konsolda yazdırın
    - Text Box'a "Merhaba Dunya'" yazın.
    - TextBox'in altinda bulunan "Elemental Selenium" linkini textinin görünür olduğunu doğrulayın ve
    konsolda yazdırın
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
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        //- "An IFrame containing..."textinin erişilebilir olduğunu test edin ve konsolda yazdırın
        WebElement baslikElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());

        WebElement iFrameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textKutusu=driver.findElement(By.xpath("//*[@id='tinymce']"));
        textKutusu.clear();
        textKutusu.sendKeys("Merhaba Dünya!");
        Thread.sleep(2000);

        // - TextBox'in altinda bulunan "Elemental Selenium" linkini textinin görünür olduğunu doğrulayın ve
        //    konsolda yazdırın
        // link  yazı elementini doğru locate etmemize rağmen bulamadı. Önce iframe den çıkmamız lazım
        driver.switchTo().defaultContent();
        WebElement textBoxYaziElementi=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(textBoxYaziElementi.isDisplayed());
        System.out.println(textBoxYaziElementi.getText());
        Thread.sleep(2000);





    }
}
