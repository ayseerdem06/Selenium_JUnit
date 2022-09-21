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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_automationexercise {
    /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
    5. Verify 'New User Signup!' is visible
    6. Enter name and email address
    7. Click 'Signup' button
    8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    9. Fill details: Title, Name, Email, Password, Date of birth
    10. Select checkbox 'Sign up for our newsletter!'
    11. Select checkbox 'Receive special offers from our partners!'
    12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    13. Click 'Create Account button'
    14. Verify that 'ACCOUNT CREATED!' is visible
    15. Click 'Continue' button
    16. Verify that 'Logged in as username' is visible
    17. Click 'Delete Account' button
    18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    Türkçesi :
    1. Tarayıcıyı başlatın
    2. 'http://automationexercise.com' URL'sine gidin
    3. Giriş sayfasının başarıyla göründüğünü doğrulayın
    4. 'Kayıt / Giriş' düğmesine tıklayın
    5. 'Yeni Kullanıcı Kaydı!' ifadesinin görünür olduğunu doğrulayın
    6. Adı ve e-posta adresini girin
    7. 'Kaydol' düğmesine tıklayın
    8. 'HESAP BİLGİLERİNİ GİRİN' seçeneğinin görünür olduğunu doğrulayın
    9. Ayrıntıları doldurun: Unvan, İsim, E-posta, Şifre, Doğum tarihi
    10. 'Bültenimize kaydolun!' onay kutusunu işaretleyin.
    11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu işaretleyin.
    12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Telefonu Numarası
    13. 'Hesap Oluştur düğmesine' tıklayın
    14. "HESAP OLUŞTURULDU!"nun görünür olduğunu doğrulayın
    15. 'Devam' düğmesine tıklayın
    16. "Kullanıcı adı olarak oturum açtı" seçeneğinin görünür olduğunu doğrulayın
    17. 'Hesabı Sil' düğmesine tıklayın
    18. 'HESAP SİLİNDİ!' ifadesinin görünür olduğunu doğrulayın ve 'Devam' düğmesini tıklayın

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
    public void test() throws InterruptedException {
        //2-'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com/"));


        // 4. 'Kayıt / Giriş' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        // 5. 'Yeni Kullanıcı Kaydı!' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());

        // 6. Adı ve e-posta adresini girin
        driver.findElement(By.xpath("//*[@name='name']")).sendKeys("Ayse");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys("ayse02@gmail");
        Thread.sleep(1000);


        // 7. 'Kaydol' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();

        // 8. 'HESAP BİLGİLERİNİ GİRİN' seçeneğinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Enter Account Information']")).isDisplayed());

        // 9. Ayrıntıları doldurun: Unvan, İsim, E-posta, Şifre, Doğum tarihi
        //Unvan
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='id_gender2']")).click();
        //Şifre
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("1234");
        //Day
        Thread.sleep(1000);
        WebElement ddmDay =driver.findElement(By.xpath("//*[@id='days']"));   // Date kısmını liste attık
        Select selectDay=new Select(ddmDay);                      // Select ile açılır pencereye ulaşmak için yeni bir  variable tanımladık
        selectDay.selectByValue("1");                              // açılır pencereden 7 ye value ile ulaştık

        //Month
        Thread.sleep(1000);
        WebElement ddmMonth=driver.findElement(By.xpath("//*[@id='months']"));
        Select selectMont=new Select(ddmMonth);
        selectMont.selectByValue("1");

        //year
        Thread.sleep(1000);
        WebElement ddmYear=driver.findElement(By.xpath("//*[@id='years']"));
        Select selecYear=new Select(ddmYear);
        selecYear.selectByValue("1982");

        // 10. 'Bültenimize kaydolun!' onay kutusunu işaretleyin.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();

        // 11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu işaretleyin.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='optin']")).click();

        // 12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke,
        // Eyalet, Şehir, Posta Kodu, Cep Telefonu Numarası
        //FirstName
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Ayse");
        //LastName
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Erdem");
        //Company
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Radisas");
        // adresses1
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Gultepe mah");
        // adresses2
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("Orkide Park Konutları");
        //Country
        Thread.sleep(1000);
        WebElement country=driver.findElement(By.xpath("//*[@id='country']"));
        Select selectCountry=new Select(country);
        selectCountry.selectByValue("Canada");
        // state
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Ontario");
        //city
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Toronto");
        //Zipcode
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("1452");
        //Mobile Number
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("9005001254523");

        // 13. 'Hesap Oluştur düğmesine' tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();

        // 14. "HESAP OLUŞTURULDU!"nun görünür olduğunu doğrulayın
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//b")).isDisplayed());

        //15. 'Devam' düğmesine tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //16. "Kullanıcı adı olarak oturum açtı" seçeneğinin görünür olduğunu doğrulayın
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed());

        //17. 'Hesabı Sil' düğmesine tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='fa fa-trash-o']")).click();

        //18. 'HESAP SİLİNDİ!' ifadesinin görünür olduğunu doğrulayın ve 'Devam' düğmesini tıklayın
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Are you sure you want to delete this Delete Account?']")).isDisplayed());

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Delete']")).click();






    }



}
