package tekrarDay14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void test1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        // İngilizce Başkentler sutununu yazdıralım
        int sonSatir= workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatir);
        String satirdakiData="";

        for (int i = 0; i <=sonSatir ; i++) {
            satirdakiData=C02_ReadExcel.banaDataGetir(i,1);
            System.out.println(satirdakiData);

        }

    }
}
