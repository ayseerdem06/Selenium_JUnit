package tekrarDay14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel extends TestBaseBeforeAfter {

    @Test
    public void readExcelTest1() throws IOException {

        // input olarak verilen
        // satırNo, sutunNo değerlerini parametre olarak alıp
        // 0 cell'deki datayı String olarak bana döndüren bir method oluşturun.

        int satirNo=4;
        int sutunNo=4;

        //donen String'in Cezayir olduğunu test edin
        String  expectedData="Cezayir";

        String actulaData=banaDataGetir(satirNo-1,sutunNo-1);   // cünkü excel index ile çalışır ve index 0 dan başlar
        Assert.assertEquals(expectedData,actulaData);

    }

    public static String banaDataGetir(int satirIndex, int sutunIndex) throws IOException {

        String istenenData="";
        String dosyaYolu="src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        istenenData=workbook.getSheet("Sayfa1").getRow(satirIndex).getCell(sutunIndex).toString();


        return  istenenData;

    }

}
