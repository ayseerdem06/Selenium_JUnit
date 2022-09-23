package tekrarDay11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C04_FileUp extends TestBaseBeforeAfter {

    /*
        Tests packagenin altina bir class oluşturun : C05_UploadFile
        https://the-internet.herokuapp.com/upload adresine gidelim
        chooseFile butonuna basalim
        Yuklemek istediginiz dosyayi secelim.
        Upload butonuna basalim.
        “File Uploaded!” textinin goruntulendigini test edelim.
     */

    @Test
    public void Test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSecButonu=driver.findElement(By.id("file-upload"));

       // Yuklemek istediginiz dosyayi secelim.
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\Dosya.txt";
        String yuklenecekDosya=farkliKisim+ortakKisim;
        dosyaSecButonu.sendKeys(yuklenecekDosya);
        Thread.sleep(5000);

        // Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@class='button']")).click();

        // “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement FileUpluaded=driver.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(FileUpluaded.isDisplayed());




    }
}
