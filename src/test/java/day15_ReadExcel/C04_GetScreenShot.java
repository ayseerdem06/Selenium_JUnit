package day15_ReadExcel;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenShot extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {

        // Amazon sayfasına gidelim  tum sayfanın resmini alalım
        driver.get("https://amazon.com");
    /*
    Bir web sayfanin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
    gecici bir File class'indan degiskene TakesScreenShot'tan olusturdugum obje'den
    tss.getScreenshotAs method'unu kullanarak gecici bir file olustururuz
    */

        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfaResmi = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/allPage.jpeg"));



      //  FileUtils.copyFile(tumSayfaResmi,new File("target/screenShot/"+driver.getTitle()+"AllPage.jpeg"));
       // getTitle ile yazdırma
    }
}
