package Odevler_Day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev5_Facebook {
     /*
    1. Bir class oluşturun : RadioButtonTest
    2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        - https://www.facebook.com adresine gidin
        - Cookies’i kabul edin
        - “Create an Account” button’una basin
        - “radio buttons” elementlerini locate edin
        - Secili degilse cinsiyet butonundan size uygun olani secin
     */

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
    public void test() throws InterruptedException {
        //- https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //- Cookies’i kabul edin
        // Cookies çıkmadığından herhangi bir işlem yapılmadı

        //- “Create an Account” button’una basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // - “radio buttons” elementlerini locate edin
        WebElement radioButtonWoman=driver.findElement(By.xpath("(//input[@class='_8esa'])[1]"));
        WebElement radioButtonMan=driver.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
        WebElement radioButtonSpecial=driver.findElement(By.xpath("(//input[@class='_8esa'])[3]"));


        //  - Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(2000);
        if(!radioButtonWoman.isSelected()){
            radioButtonWoman.click();
        }

        Thread.sleep(2000);
        radioButtonMan.click();
        Thread.sleep(2000);
        radioButtonSpecial.click();


    }

}
