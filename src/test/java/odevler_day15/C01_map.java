package odevler_day15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C01_map {

    /*
    1.satirdaki 2.hucreye gidelim ve yazdiralim
    1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
    2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
    Satir sayisini bulalim
    Fiziki olarak kullanilan satir sayisini bulun
    Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
     */

    @Test
    public void test1() throws IOException {

        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //1.satirdaki 2.hucreye gidelim ve yazdiralim
        // 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String hucre = workbook.getSheet("Sayfa1").getRow(1).getCell(2).toString();
        System.out.println(hucre);

        // 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String actualRow=workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
       // String expectedRo




        Map<String,String> ulkelerMap=new TreeMap<>();
        int sonSatirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i <=sonSatirSayisi ; i++) {
            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()+
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);

        }




    }
}
