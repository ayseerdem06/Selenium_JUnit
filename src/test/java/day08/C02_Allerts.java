package day08;

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

import java.time.Duration;

public class C02_Allerts {
    /*
    Bir class olusturun: Alerts
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel(iptal) butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    /*
    bir web sitesine girdigimizde karsımıza bir uyarı mesajı yada bir buttona tıkladığımızda bir uyarı cıkabilir
    eğer bu uyarıya incele(mause sağ-tik inspect) yapabiliyorsak bu tür alert lere html alert denir.
    ve istedigimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdahale (sağ tik inspect ile) edemiyorsak
    bu tür alertlere  js alert denir.
    js alert'lere müdahale edebilmek icin

    -- tamam ya da ok icin
    driver.switchTo().alert().accept();

    --iptal icin
    driver.switchTo().alert().dismiss();

    --alert icindeki mesajı almak icin
    driver.switchTo().alert().getText();

    --alert bizden bir metin istiyorsa
    driver.switchTo().alert().sendKeys("");

    methodları kullanilir!!

    /*NOTT;
  Eger soru içerdiğini diyorsa Asserttrue
  Eger soru içermediğini diyorsa Assertfalse
  Eger soru ...oldugunu/esitmı diyorsa Asserequalse
  Eger soru ...olmadıgını/esitolmadıgını diyorsa AsssertNotEqualse

     */

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        // 1. butona tıklayın, uyarıdaki OK (tamam) butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        WebElement mesaj=driver.findElement(By.xpath("//*[@id='result']"));
        String expectedMEsaj="You successfully clicked an alert";
        String actualMEsaj=mesaj.getText();
        Assert.assertEquals(expectedMEsaj,actualMEsaj);

    }

    @Test
    public void test2() throws InterruptedException {

        //    2. butona tıklayın, uyarıdaki Cancel(iptal) butonuna tıklayın ve result mesajının
        //    “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
       //Alert üzerindeki mesajı yazdırın
        System.out.println("2.Buttonun Alert Mesajı = "+driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        String actualMesaj = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj = "successfuly";
        Assert.assertFalse(actualMesaj.contains(expectedMesaj));
    }

    @Test
    public void test3() throws InterruptedException {

        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        //Alert üzerindeki mesajı yazdırın
        System.out.println("3.Buttonun Alert Mesajı = "+driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Ayse Erdem");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String actualMEsaj3=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedMesaj3="Ayse Erdem";
        Assert.assertTrue(actualMEsaj3.contains(expectedMesaj3));



    }

}
