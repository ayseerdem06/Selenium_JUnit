package day10_Actions;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C01_IlkTestBaseClass extends TestBaseBeforeAfter {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

    }

}
