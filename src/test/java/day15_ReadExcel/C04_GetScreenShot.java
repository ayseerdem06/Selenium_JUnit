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
        Bir web sayfanın resmini alabilmek için TakesScreenshot class'ın obje oluşturup
        Geçici bir File class'ından değişkene TakesScreenShot'dan oluşturduğum obje'den getScreenShotAs
        methonu kullanarak geçici bir file oluştururuz
         */
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));


        //FileUtils.copyFile(tumSayfaResmi,new File("target/screenShot/"+driver.getTitle()+"AllPage.jpeg"));
        //getTitle ile yazdırma
    }
}
