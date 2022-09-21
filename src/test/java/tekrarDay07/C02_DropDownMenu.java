package tekrarDay07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_DropDownMenu {
    /*
    amazona gidip dropdown'dan books seçeneği seçip Java aratalım
    ve arama sonuçlarının Java içerdiğini test edelim
     */

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
       // driver.close();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.amazon.com");
        //1. adım dropdown I locate edelim
        WebElement ddm= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddm);

        // Dropdown larda var olan optionlardan birini yazalım
        // TextBox ile
        select.selectByVisibleText("Books");
        // index ile
        //select.selectByIndex(5);     // index 0 dan başlar. manuel olarak kaçıncı sırada olduğunu önceden test ederiz
        // Value ile
        //select.selectByValue("search-alias=stripbooks-intl-ship");

        // arama kutusu Java yazdıralım
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        WebElement sonucYazisiElementi=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisi=sonucYazisiElementi.getText();
        String arananKelime="Java";
        Assert.assertTrue(sonucYazisi.contains(arananKelime));

        Thread.sleep(2000);


    }



}
