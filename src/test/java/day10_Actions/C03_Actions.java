package day10_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Actions extends TestBaseBeforeAfter {

    @Test
    public void test01(){
        // - Amazon sayfasına gidelim
        // - Account menusunden create a list linkine tıklayalım

        driver.get("https://amazon.com");
        WebElement accountList = driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde
        html kodları arasında web elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable exception'ı fırlatır
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();


    }

}
