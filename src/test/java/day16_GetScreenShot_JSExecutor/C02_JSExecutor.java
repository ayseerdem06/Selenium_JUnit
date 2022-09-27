package day16_GetScreenShot_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_JSExecutor extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Asagidaki carreers butonunu gorunceye kadar js ile scroll yapalim
        WebElement carreers=driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",carreers);

        // arguments[0].scrollIntoView(true); ile sayfanın aşağı inip o elemente gitmesi için kullanılan Java S kodu

        //Carreers butonuna js ile click yapalim
        jse.executeScript("arguments[0].click();",carreers);


    }
}
