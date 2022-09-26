package odevler_day13;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02 {

    /*
    Bir metod oluşturun : printData(int row, int column);
    Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
    hücredeki(cell) veriyi yazdırmalıdır.
    Baska bir Test metodu oluşturun: printDataTest( );
    Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
    Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
    yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
     */

    @Test
    public void test01() throws IOException {

        int row=2;
        int column=3;

        printData( row,  column);



    }

    public void printData(int row, int column) throws IOException {

        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String cell=workbook.getSheet("Sayfa1").getRow(row).getCell(column).toString();
        System.out.println(cell);



    }
}
