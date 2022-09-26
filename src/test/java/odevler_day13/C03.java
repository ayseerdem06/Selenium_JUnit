package odevler_day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C03 extends TestBaseBeforeAfter {

    /*
    Bir Class olusturun D19_WebtablesHomework
    “https://demoqa.com/webtables” sayfasina gidin
    Headers da bulunan department isimlerini yazdirin
    sutunun basligini yazdirin
    Tablodaki tum datalari yazdirin
    Tabloda kac cell (data) oldugunu yazdirin
    Tablodaki satir sayisini yazdirin
    Tablodaki sutun sayisini yazdirin
    Tablodaki 3.kolonu yazdirin
    Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin
     */


    @Test
    public void test01() {
        //1.“https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //2.Headers da bulunan department isimlerini yazdirin
        List<WebElement> departments = driver.findElements(By.xpath("//div[@role='gridcell'][6]"));
        departments.forEach(t -> System.out.println(t.getText()));
        //3.sutun basliklarini yazdirin
        WebElement row = driver.findElement(By.xpath("//div[@class='rt-tr']"));
        System.out.println("Sutun basliklari : " + row.getText());
        //4.Tablodaki tum datalari yazdirin
        WebElement allTable = driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println("Tum tablo : " + allTable.getText());
        //5.Tabloda kac cell (data) oldugunu yazdirin
        List<WebElement> tableCells = driver.findElements(By.xpath("//div[@class='rt-td']"));
        System.out.println("Tablodaki toplam cell sayisi : " + tableCells.size());
        List<String> tableDataList = new ArrayList<>();
        for (int i = 0; i < tableCells.size(); i++) {
            if (!tableCells.get(i).getText().isBlank()) {
                tableDataList.add(tableCells.get(i).getText());
            }
        }
        System.out.println("Tabloda icinde veri bulunan cell sayisi : " + tableDataList.size());
        //6.Tablodaki satir sayisini yazdirin
        List<WebElement> rowList = driver.findElements(By.xpath("//div[@role='row']"));
        System.out.println("Tablodaki satir sayisi : " + rowList.size());
        //7.Tablodaki sutun sayisini yazdirin
        List<WebElement> columnList = driver.findElements(By.xpath("//div[@role='columnheader']"));
        System.out.println("Tablodaki sutun sayisi : " + columnList.size());
        //8.Tablodaki 3.kolonu yazdirin
        List<WebElement> thirdColumnList = driver.findElements(By.xpath("//div[@class='rt-td'][3]"));
        thirdColumnList.forEach(t -> System.out.println(t.getText()));
        //9.Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        String expectedFirstName = "Kierra";
        List<WebElement> firstNameList = driver.findElements(By.xpath("//div[@class='rt-td'][1]"));
        int indeks = 0;
        for (int i = 0; i < firstNameList.size(); i++) {
            if (firstNameList.get(i).getText().equals(expectedFirstName)) {
                indeks = i;
            }
        }
        List<WebElement> salaryList = driver.findElements(By.xpath("//div[@class='rt-td'][5]"));
        System.out.println(expectedFirstName + " isimli kisinin salary degeri : " + salaryList.get(indeks).getText());
        //10.Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
        getData(2, 3);
    }

    private void getData(int column, int row) {
        WebElement data = driver.findElement(By.xpath("(//div[@class='rt-td'][" + column + "])[" + row + "]"));
        System.out.println(column + ". sutun " + row + ". satirdaki veri : " + data.getText());
    }
}

