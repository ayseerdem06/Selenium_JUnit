package Practice;

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

public class C02_DogruEmailVeSifre {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Delete Account' button
    10. Verify that 'ACCOUNT DELETED!' is visible

    Tercümesi :
            1. Tarayıcıyı başlatın
            2. 'http://automationexercise.com' URL'sine gidin
            3. Giriş sayfasının başarıyla göründüğünü doğrulayın
            4. 'Kayıt / Giriş' düğmesine tıklayın
            5. "Hesabınıza giriş yapın"ın görünür olduğunu doğrulayın
            6. Doğru e-posta adresini ve şifreyi girin
            7. 'Giriş yap' düğmesine tıklayın
            8. "Kullanıcı adı olarak oturum açtım" seçeneğinin görünür olduğunu doğrulayın
            9. 'Hesabı Sil' düğmesine tıklayın
            10. 'HESAP SİLİNDİ!' ifadesinin görünür olduğunu doğrulayın

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
    public void tearDown() throws InterruptedException {

       driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        //  2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Giriş sayfasının başarıyla göründüğünü doğrulayın
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));


        //  4. 'Kayıt / Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        // 5. "Hesabınıza giriş yapın"ın görünür olduğunu doğrulayın
        WebElement girisSayfasi=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(girisSayfasi.isDisplayed());

        //  6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("ayse02@gmail");
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("1234");

        // 7. 'Giriş yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        // 8. "Kullanıcı adı olarak oturum açtım" seçeneğinin görünür olduğunu doğrulayın
        WebElement login=driver.findElement(By.xpath("//a"));
        Assert.assertTrue(login.isDisplayed());

        //9. 'Hesabı Sil' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();

        //10. 'HESAP SİLİNDİ!' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());



    }
}
