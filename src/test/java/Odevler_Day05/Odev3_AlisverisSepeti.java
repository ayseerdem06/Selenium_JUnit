package Odevler_Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev3_AlisverisSepeti {
    public static void main(String[] args) throws InterruptedException {

         /*
    1.“https://www.saucedemo.com”Adresine gidin
    2.Username kutusuna “standard_user” yazdirin
    3.Password kutusuna “secret_sauce” yazdirin
    4.Login tusunabasin
    5.Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    6.Add to Cart butonuna basin
    7.Alisveris sepetine tiklayin
    8.Sectiginiz urunun basarili olarak sepete eklendigini control edin
    9.Sayfayi kapatin
     */

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1.“https://www.saucedemo.com”Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2.Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // 3.Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("secret_sauce");

        //4.Login tusunabasin
        driver.findElement(By.id("login-button")).click();

        //5.Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        //6.Add to Cart butonuna basin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Add to cart'][1]")).click();
        driver.findElement(By.xpath("//*[@class='inventory_item_img'][1]")).click();


       // 7.Alisveris sepetine tiklayin
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_badge")).click();


        //8.Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepettekiUrun=driver.findElement(By.className("inventory_item_name"));
        String sepettekiUrunText=sepettekiUrun.getText();
        WebElement eklenenUrun=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        String eklenenUrunText=eklenenUrun.getText();

        if(sepettekiUrunText.equals(eklenenUrunText)){
            System.out.println("UrunUN sepete eklenme testi PASSED");
        }else System.out.println("Urunun sepete eklenme testi FAILED");

        driver.close();

    }
}
