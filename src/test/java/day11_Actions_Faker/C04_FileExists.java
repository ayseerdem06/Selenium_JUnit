package day11_Actions_Faker;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {
    @Test
    public void test1() {

        System.out.println(System.getProperty("user.dir"));  //C:\Users\PC\IdeaProjects\com.Batch81JUnit
        System.out.println(System.getProperty("user.home"));  //C:\Users\PC

        String farklıBolum=System.getProperty("user.home");
        // C:\Users\PC\Desktop\Dosya.txt ( masa üstündeki  dosyanın yolu


        String dosyaYolu="C:\\Users\\PC\\Desktop\\Dosya.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
