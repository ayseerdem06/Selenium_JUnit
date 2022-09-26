package tekrarDay14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class C01_RedExcel  {

    @Test
    public void test1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);    // WorkbookFabrikasına gidilir işleme alınan excel dosyası için sanal bir workbook oluşturulur

        String actualData =workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();



    }


}
