package tekrarDay13_Cookies;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C02_WebTables extends TestBaseBeforeAfter {

   /*
    Bir class oluşturun : C02_WebTables
    login( ) metodun oluşturun ve oturum açın.
    https://www.hotelmycamp.comadmin/HotelRoomAdmin adresine gidin
    Username : manager
    Password : Manager1!
    table( ) metodu oluşturun
    Tüm table body’sinin boyutunu(sutun sayisi) bulun.
    Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    printRows( ) metodu oluşturun //tr
    table body’sinde bulunan toplam satir(row) sayısını bulun.
    Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    4.satirdaki(row) elementleri konsolda yazdırın.
     // email başlığındaki tum elementleri (sutun) konsolda yazdırın
     */

    @Test
    public void test1(){

        login1();


    }
    public void login1() {
        //  https://www.hotelmycamp.comadmin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");

        // Username : manager  ○ Password : Manager1!
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunBaslıklariListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun Sayisi :"+ sutunBaslıklariListesi.size());

        // Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBady=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBady.getText());

        //  table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tboday//tr"));
        System.out.println("Satir Sayisi : "+ satirlarListesi.size());

       // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w:satirlarListesi ) {
            System.out.println(w.getText());
        }


       // 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("Tablodaki 4. satır : "+driver.findElement(By.xpath("//tbody//tr[4]")).getText());


        // önce naim başlığının kaçıncı numarada olduğunu bulalım
        // naim başlığındaki tum elementleri (sutun) konsolda yazdırın
       List<WebElement> basliklarListesi=driver.findElements(By.xpath("//thead//tr[1]//th"));
       int nameSutunNo=0;
        for (int i = 0; i <basliklarListesi.size() ; i++) {
            if(basliklarListesi.get(i).getText().equals("Name")){
                nameSutunNo=i;
            }

        }

        //List<WebElement> nameSutunListesi=driver.findElements(By.xpath("tbody//td[3]"));
        List<WebElement>nameSutunListesi=driver.findElements(By.xpath("//tbody//td["+(nameSutunNo+1)+"]"));
        for (WebElement w: nameSutunListesi ) {
            System.out.println(w.getText());

        }



    }
}
