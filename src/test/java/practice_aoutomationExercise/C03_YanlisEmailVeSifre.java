package practice_aoutomationExercise;

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

public class C03_YanlisEmailVeSifre {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter incorrect email address and password
    7. Click 'login' button
    8. Verify error 'Your email or password is incorrect!' is visible

    Türkce Cevirisi :
    1. Tarayıcıyı başlatın
    2. 'http://automationexercise.com' URL'sine gidin
    3. Giriş sayfasının başarıyla göründüğünü doğrulayın
    4. 'Kayıt / Giriş' düğmesine tıklayın
    5. "Hesabınıza giriş yapın"ın görünür olduğunu doğrulayın
    6. Yanlış e-posta adresi ve şifre girin
    7. 'Giriş yap' düğmesine tıklayın
    8. 'E-posta adresiniz veya şifreniz yanlış!' hatasının görünür olduğunu doğrulayın

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
    public void tearDown() throws InterruptedException {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // 2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Giriş sayfasının başarıyla göründüğünü doğrulayın
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));

        // 4. 'Kayıt / Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        // 5. "Hesabınıza giriş yapın"ın görünür olduğunu doğrulayın
        WebElement girisSayfasi=driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(girisSayfasi.isDisplayed());

        // 6. Yanlış e-posta adresi ve şifre girin
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("ayse@gmail");
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("01234");

        // 7. 'Giriş yap' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();

        // 8. 'E-posta adresiniz veya şifreniz yanlış!' hatasının görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed());


    }


}
