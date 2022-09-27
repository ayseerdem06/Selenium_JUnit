package practice_dersi02;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P02 {

    @Test
    public void test01(){

        //Verify that we have pom.xml file in our project => please try in 4 min s
        //Projenizde Pom.xml varmıdır diye test edin

        String dosyaYolu="C:\\Users\\PC\\IdeaProjects\\com.Batch81JUnit\\pom.xml";
        // absolute path ile dosya yolu alındı
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
