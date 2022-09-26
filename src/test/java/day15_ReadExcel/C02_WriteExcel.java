package day15_ReadExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    // 1)Yeni bir Class olusturalim WriteExcel
    // 2) Yeni bir test method olusturalim writeExcelTest()
    // 3) Adimlari takip ederek 1.satira kadar gidelim
    // 4) 5.hucreye yeni bir cell olusturalim
    // 5) Olusturdugumuz hucreye "Nufus" yazdiralim
    // 6) 2.satir nufus kolonuna 1500000 yazdiralim
    // 7) 10.satir nufus kolonuna 250000 yazdiralim
    // 8) 15.satir nufus kolonuna 54000 yazdiralim
    // 9)Dosyayi kaydedelim
    // 10)Dosyayi kapatalim

    @Test
    public void test01() throws IOException {

        // 1)Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        // 2) FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        // 3) Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //  WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);

        //5.hucreye yeni bir cell olusturalim
        //Olusturdugumuz hucreye “Nufus” yazdiralim
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        //2.satir nufus kolonuna 1500000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1.500.000");
        //10.satir nufus kolonuna 250000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250.000");
        //15.satir nufus kolonuna 54000 yazdiralim
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54.000");
        //Dosyayi kaydedelim
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        // Excel dosyamıza veri girişi yaptıktan sonra dosyayı akışa aldığımız gibi sonlandırmamız gerekir.
        // Sonrasında da workbook objemize kayıt etmemiz gerekir
        workbook.write(fos); // Write methodu ile sonlandırdığımız işlemi workbook'a yazdırdık
        //Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();


    }
}

