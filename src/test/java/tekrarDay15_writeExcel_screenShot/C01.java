package tekrarDay15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C01 extends TestBaseBeforeAfter {

    @Test
    public void tumSayfa() throws IOException {

        // amazon sayfasına gidip tum sayfanın fotografını cekelim
        driver.get("https://www.bestbuy.com");
        TakesScreenshot ts= (TakesScreenshot) driver;

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(dtf);

        File tumSayfaResim=new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");
        File geciciDosya=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciDosya,tumSayfaResim);


    }
}
