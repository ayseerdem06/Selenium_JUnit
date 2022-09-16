package Odevler_Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev2_NutellaTekrarTesti {
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
        // cookies uyarı çıkmadığından herhangi bir işlem yapılmadı

        //4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle="Google";
        String actualTitle=driver.getTitle();
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Sayfa Basligi Testi PASSED");
        }else System.out.println("Sayfa Basligi Testi FAILED");


        // 5 Arama cubuguna “Nutella” yazip aratin
        WebElement aramaCubugu=driver.findElement(By.xpath("//*[@class='gLFyf gsfi']"));
        aramaCubugu.sendKeys("Nutella"+ Keys.ENTER);


        //6 Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonucText=sonucYazisi.getText();
        String [] sonucSayisi=sonucText.split(" ");
        System.out.println("Bulunan Sonuc Sayisi : "+ sonucSayisi[1]);

        //7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        int  sonucSys=Integer.parseInt(sonucSayisi[1].replaceAll("\\D",""));
        if(sonucSys>10000000){
            System.out.println("Sonuc 10 Milyondan fazla PASSED");
        }else System.out.println("Sonuc 10 Milyondan az FAILED");

        //8 Sayfayi kapatin
        driver.close();





    }
}
