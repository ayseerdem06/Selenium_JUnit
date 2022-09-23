package odevler_day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C03_eksikTamamlanacak extends TestBaseBeforeAfter {

    /*

    Test01-
    1-amazon gidin
    2-Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    3-dropdown menude 40 eleman olduğunu doğrulayın

    Test02
    1-dropdown menuden elektronik bölümü seçin
    2-arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    3-sonuc sayisi bildiren yazinin iphone icerdigini test edin
    4-ikinci ürüne relative locater kullanarak tıklayin
    4-ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim

    Test03
    1-yeni bir sekme açarak amazon anasayfaya gidin
    2-dropdown’dan bebek bölümüne secin
    3-bebek puset aratıp bulundan sonuç sayısını yazdırın
    4-sonuç yazsının puset içerdiğini test edin
    5-üçüncü ürüne relative locater kullanarak tıklayin
    6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin  Test 4
    7-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
     */


    @Test
    public void Test01() {

        // 1-amazon gidin
        driver.get("https://www.amazon.com");

        // 2-Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        List<WebElement> liste=new ArrayList<>(select.getOptions());

        for (WebElement w:liste
             ) {
            System.out.println(w.getText());
        }

        // 3-dropdown menude 40 eleman olduğunu doğrulayın
        int actualElementSayisi=liste.size();   //28
        int expectedElementSayisi=40;
        Assert.assertNotEquals(expectedElementSayisi,actualElementSayisi);


    }

    @Test
    public void Test02() throws InterruptedException {

        driver.get("https://www.amazon.com");
        // 1-dropdown menuden elektronik bölümü seçin

        WebElement ddm=driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        //ddm.sendKeys("Electronics");
        Select select=new Select(ddm);
        select.selectByVisibleText("Electronics");

        //2-arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).
                            sendKeys("iphone"+Keys.ENTER);
        WebElement sonuc=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisi=sonuc.getText();
        System.out.println(sonuc.getText());        // sonuc yazısını görmek için ekledim
        String [] arr=sonucYazisi.split(" ");
        System.out.println("Bulunan sonuc sayisi : "+ arr[2]);

        // 3-sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucYazisi.contains("iphone"));

        //4-ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@data-image-index='2'])[1]")).click();

        //  4-ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        WebElement urunTitle=driver.findElement(By.xpath("//*[@id='productTitle']"));
        String urunTitliYazisi=urunTitle.getText();
        System.out.println("Urun title yazisi: "+ urunTitliYazisi);

        WebElement fiyat=driver.findElement(By.xpath("//*[@class='a-price a-text-price a-size-medium apexPriceToPay']"));
        String urunFiyati=fiyat.getText();
        System.out.println("Urunun fiyati : "+ urunFiyati);

        WebElement addButonu=driver.findElement(By.xpath("//*[@id='exportsUndeliverable-cart-announce']"));
        addButonu.click();
    }

    @Test
    public void Test03() {

        // 1-yeni bir sekme açarak amazon anasayfaya gidin



    }


}
