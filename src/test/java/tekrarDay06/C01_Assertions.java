package tekrarDay06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public  void test(){
        driver.get("https://www.amazon.com");

        // url'in https://www.facebook.com olduğunu test edin.
       /*
        if (driver.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println("URL testi Passed");
        }else System.out.println("URL testi Failed");

        Eğer testleri if ile yaparsak test failed test failed olsa bile kodlar problemsiz çalıştığı için
        kod çalışması bittiğinde ekranın sol alt kısmında Test passed yazacaktır.
        */

        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("URL beklenenden farklı ",expectedUrl,actualUrl);

        /*
        Assertion ile yaptığımız testlerde assertion failed olursa Java kodların
        çalışmasını durdurur ve assert class'ı bizi hata konusunda bilgilendirir .
         */

    }
}
