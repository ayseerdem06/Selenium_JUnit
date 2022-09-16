package Odevler_Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev2_YoutubeAssertions {

    /*
    1- https://youtube.com adresine gidin
    2- Aşağıdaki adları kullanarak 3 test methodu oluşturun ve gerekli testleri yapın
        - titleTest  => Sayfa başlığının "Youtube" olduğunu test edin
        - imageTest => Youtube resminin görüntülendiğini (isDisplayed())test edin
        - Search Box'ın erişilebilir olduğunu test edin (isEnabled()
        - wrongTitleTest => Sayfa başlığının "youtube"olmadığını doğrulayın
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromiumdriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");

    }


    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        //- titleTest  => Sayfa başlığının "Youtube" olduğunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void test2() {
        //  - imageTest => Youtube resminin görüntülendiğini (isDisplayed())test edin
        WebElement image = driver.findElement(By.xpath("//*[@class='style-scope ytd-logo'][1]"));
        Assert.assertTrue(image.isDisplayed());
    }

    @Test
    public void test3() {
        //   - Search Box'ın erişilebilir olduğunu test edin (isEnabled()
        WebElement searhbox = driver.findElement(By.xpath("//*[@name='search_query']"));
        Assert.assertTrue(searhbox.isEnabled());


    }
    @Test
    public void test4() {
        // - wrongTitleTest => Sayfa başlığının "youtube"olmadığını doğrulayın
        String wrongTitle="youtube";
        String actualTitle=driver.getTitle();
        Assert.assertNotEquals(wrongTitle,actualTitle);
    }

}
