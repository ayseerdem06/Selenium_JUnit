package day15_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_DeleteExcel {

    @Test
    public void test1() throws IOException {

        //-Dosya yolunu bir String degiskene atayalim
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        //-Sheet objesi olusturun workbook.getSheetAt(Sayfa1)
        //-Row objesi olusturun sheet.getRow(3)
        //-Cell objesi olusturun row.getCell(3)
        //-3. Satır 3. Cell'deki veriyi silelim
        //-Silindiğini test edin



        // 1)Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        // 2) FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        // 3) Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //  WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //4) Sheet objesi olusturun workbook.getSheetAt(Sayfa1)

    }
}
