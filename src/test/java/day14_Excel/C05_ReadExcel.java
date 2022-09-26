package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcel {

    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin


        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        // Sayfa 2 ye gidip,
        // satır sayisinin 6, kullanılan satır sayısının ise 3 olduğunu test edin
        int sonSatirIndex=workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println(sonSatirIndex);
        int expectedSatirSayisi=6;
        Assert.assertEquals(expectedSatirSayisi,sonSatirIndex+1);

        int kullanılanSatirSayisi=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        // Excell tablosunda kullanılan satır sayısını getPhysicalNumberOfRows() methodu ile alırız.
        System.out.println(kullanılanSatirSayisi);
        int expectedKullanilanSatirSayisi=3;
        Assert.assertEquals(expectedKullanilanSatirSayisi,kullanılanSatirSayisi);
    }
}
