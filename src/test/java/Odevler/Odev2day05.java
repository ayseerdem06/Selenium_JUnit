package Odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev2day05 {
    public static void main(String[] args) {
         /*
        1-C01_TekrarTesti isimli bir class olusturun
        2- https://www.google.com/ adresine gidin
        3- cookies uyarisini kabul ederek kapatin
        4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        5 Arama cubuguna “Nutella” yazip aratin
        6 Bulunan sonuc sayisini yazdirin
        7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        8 Sayfayi kapatin
         */

        WebDriverManager.chromiumdriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek kapatin


    }
}
