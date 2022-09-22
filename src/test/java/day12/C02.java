package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C02 extends TestBaseBeforeAfter {

    @Test
    public void test1() {
/*
        Tests packagenin altina bir class oluşturun : C05_UploadFile
        https://the-internet.herokuapp.com/upload adresine gidelim
        chooseFile butonuna basalim
        Yuklemek istediginiz dosyayi secelim.
        Upload butonuna basalim.
        “File Uploaded!” textinin goruntulendigini test edelim.
 */

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        WebElement dosyaSec=driver.findElement(By.xpath("//*[@id='file-upload']"));
        String dosyaYolu="C:\\Users\\PC\\Desktop\\Dosya.txt";
        dosyaSec.sendKeys(dosyaYolu);

         /*
        Dosyasec butonuna direk click yapamayabiliriz çünkü windows'a müdahaleye izin vermeyebilir
        Bu yüzden Dosyasec butonunu direk locate edip sendKeys() methodu ile string değişkene atadığımız dosya yolumuzu
        göndeririz.
         */

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());


    }
}
