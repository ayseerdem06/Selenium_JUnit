package Odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev1day05 {
    public static void main(String[] args) throws InterruptedException {
         /*
        1. http://zero.webappsecurity.com sayfasina gidin
        2. Signin buttonuna tiklayin
        3. Login alanine “username” yazdirin
        4. Password alanine “password” yazdirin
        5. Sign in buttonuna tiklayin
        6. Pay Bills sayfasina gidin
        7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        8. tarih kismina “2020-09-10” yazdirin
        9. Pay buttonuna tiklayin
        10. “The payment was successfully submitted.” mesajinin ciktigini control edin
         */

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com sayfasina gidin

        driver.get("http://zero.webappsecurity.com");

        // 2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();

        // 3. Login alanine “username” yazdirin
        WebElement loginButon=driver.findElement(By.xpath("//*[@id='user_login']"));
        loginButon.sendKeys("username");

        //4. Password alanine “password” yazdirin
        WebElement password=driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        // hata mesajı için back e tıklayın geri gelin
        WebElement signin =driver.findElement(By.xpath("//*[@name='submit']"));
        signin.click();
        driver.navigate().back();


        //6. Online Banking sayfasından Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //7- amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("500");
        Thread.sleep(2000);

        //  8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");
        Thread.sleep(2000);


        // 9. Pay buttonuna tiklayin
       driver.findElement(By.id("pay_saved_payees")).click();
       Thread.sleep(2000);


        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if(sonucYazisiElementi.isDisplayed()){
            System.out.println("Sonuc Yazisi Elementi PASSED");
        }else System.out.println("Sonuc Yazisi Elementi FAILED");

        driver.close();


    }
}
