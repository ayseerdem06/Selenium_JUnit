package tekrarDay11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    @Test
    public void Test01() {

        System.out.println(System.getProperty("user.dir"));
        // C:\Users\PC\IdeaProjects\com.Batch81JUnit  bana içinde olduğum projenin dosya yolunu (path) verir

        System.out.println(System.getProperty("user.home"));   //"C:\Users\PC\Desktop\Dosya.txt"   dosya yolu
        String dosyaYoluBenim=System.getProperty("user.home");
        //C:\Users\PC  benim bilgisayarımın bana özel kısmını verir

        //"C:\Users\PC\Desktop\selenium-java-4.4.0"   dosya yolu
        // "C:\Users\PC\Desktop\Dosya.txt"   dosya yolu

        // homePath+"Download"

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Dosya.txt";
        System.out.println(dosyaYolu);    // C:\Users\PC\Desktop\text.txt

        String ortakKisim="\\Desktop\\Dosya.txt";
        String farkliKisim=System.getProperty("user.home");  // benim bilgisayarıma ait olan dosya yolu
        String masaUstuDosyaYolu=farkliKisim+ortakKisim;

        System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));

    }
}
