package tekrarDay09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBaseBeforeAfter;

public class C03_WindowHandle extends TestBaseBeforeAfter {

    /*
    Yeni bir class olusturun: WindowHandle
    Amazon anasayfa adresine gidin.
    Sayfa’nin window handle degerini String bir degiskene atayin
    Sayfa title’nin “Amazon” icerdigini test edin
    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
    Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
    Sayfa title’nin “Walmart” icerdigini test edin
    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
     */

    @Test
    public void test1() {
       //Amazon anasayfa adresine gidin.
       driver.get("https://www.amazon.com");

       //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazon = driver.getWindowHandle();

        // Sayfa title’nin “Amazon” icerdigini test edin
        String expectedTitle="Amazon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");

        // Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String expectedTitle2 = "TECHPROEDUCATION";
        String actualTitle2=driver.getTitle();
        Assert.assertFalse(actualTitle2.contains(expectedTitle2));

        // Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        //Sayfa title’nin “Walmart” icerdigini test edin
        String expectedTitle3="Walmart";
        String actualTitle3=driver.getTitle();
        Assert.assertTrue(actualTitle3.contains(expectedTitle3));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(amazon);
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        driver.quit();





    }
}
