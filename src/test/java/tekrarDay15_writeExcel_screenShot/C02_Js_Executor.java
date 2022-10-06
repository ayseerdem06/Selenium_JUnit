package tekrarDay15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_Js_Executor extends TestBaseBeforeClassAfterClass {

    @Test
    public void test01() throws InterruptedException {

        // amazona gidelim
        driver.get("https://www.amazon.com");

        // aşağıdaki sign in butonu görünceye kadar js ile scrool yapalım
        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(3000);
        WebElement signInButonu=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        js.executeScript("arguments[0].scrollIntoView(true)",signInButonu);
        Thread.sleep(3000);
        // sign in butonune js ile click yapalım
        js.executeScript("arguments[0].click();",signInButonu);
        Thread.sleep(3000);

    }
}
