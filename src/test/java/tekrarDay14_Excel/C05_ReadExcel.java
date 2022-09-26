package tekrarDay14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C05_ReadExcel {

    @Test
    public void test1() throws IOException {
        // Excel dosyasındaki tüm verileri classımıza alıp bir java objesine store edelim
        // böylcede her seferinde excel'e ulaşıp satır, sutun  vs. uğraşmayalım

        // Database yapısında olan exceli  koyabileceğimiz en uygun Java objesi map tir.
        Map<String,String> ulkelerMap=new HashMap<>();

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatirIndexi ; i++) {
            // key i nin ci satırdaki 0 index teki datadır
            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            // value ise 1 satırdaki 1,2,3 indexin datalarının birleşimi olacak
            String value= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+
                    " "+ workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+
                    " "+ workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);

        // Listede Ghana olduğunu test edin
        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));

    }
}
