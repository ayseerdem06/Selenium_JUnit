package practice_aoutomationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_LogoutUser {

    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'Login to your account' is visible
    6. Enter correct email address and password
    7. Click 'login' button
    8. Verify that 'Logged in as username' is visible
    9. Click 'Logout' button
    10. Verify that user is navigated to login page

    Türkçesi :
    1. Tarayıcıyı başlatın
    2. 'http://automationexercise.com' URL'sine gidin
    3. Giriş sayfasının başarıyla göründüğünü doğrulayın
    4. 'Kayıt / Giriş' düğmesine tıklayın
    5. "Hesabınıza giriş yapın"ın görünür olduğunu doğrulayın
    6. Doğru e-posta adresini ve şifreyi girin
    7. 'Giriş yap' düğmesine tıklayın
    8. "Kullanıcı adı olarak oturum açtım" seçeneğinin görünür olduğunu doğrulayın
    9. 'Oturumu Kapat' düğmesine tıklayın
    10. Kullanıcının oturum açma sayfasına yönlendirildiğini doğrulayın

     */

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
        //driver.close();
    }

    @Test
    public void test01(){

        // 2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Giriş sayfasının başarıyla göründüğünü doğrulayın
        String expectedUrl = "http://automationexercise.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }



}
