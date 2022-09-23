package tekrarDay11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownLoad extends TestBaseBeforeAfter {
    /*
    1- Bir class oluşturun
    2-  https://the-internet.herokuapp.com/download adresine gidelim
    3- Terimler.text dosyasını indirelim
    4- Dosyanın başarıyla indirilip indirilmediğini test edelim
     */

    @Test
    public void test01() throws InterruptedException {
        //  2-  https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");

        //3- Terimler.text dosyasını indirelim
        WebElement terimlerLinki = driver.findElement(By.xpath("//*[text()='Terimler.txt']"));
        terimlerLinki.click();
        Thread.sleep(5000);

        // Dosya downloada indirilir
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\Terimler.txt";
        String arananDosyaYolu=farkliKisim+ortakKisim;

        //geriye o dosya yolundaki dosyanın var olup olmadığını test edelim
        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));


    }
}
