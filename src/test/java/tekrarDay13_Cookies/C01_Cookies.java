package tekrarDay13_Cookies;



import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;


public class C01_Cookies extends TestBaseBeforeAfter {

    @Test
    public void test1(){

     /*
    1-Amazon anasayfaya gidin
    2-tum cookie’leri listeleyin
    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
    6-eklediginiz cookie’nin sayfaya eklendigini test edin
    7-ismi skin olan cookie’yi silin ve silindigini test edin
    8-tum cookie’leri silin ve silindigini test edin
     */

        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //  2-tum cookie’leri listeleyin
        Set<Cookie> cookieSet=driver.manage().getCookies();
        System.out.println(cookieSet);

        int sayac=1;
        for (Cookie w:cookieSet ) {
            System.out.println(sayac + ". cookie "+ w);
            System.out.println("Name : "+ w.getValue());
            System.out.println("Value : "+ w.getValue());
            sayac++ ;
        }

        //  3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookieSayisi=cookieSet.size();
        Assert.assertTrue(cookieSayisi>5);

        // 4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w:cookieSet ) {
            if(w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }

        }

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);
        cookieSet=driver.manage().getCookies();

        sayac=1;
        for (Cookie w:cookieSet ) {
            System.out.println(sayac + ". cookie "+ w);
            sayac++ ;
        }


        //   6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(cookieSet.contains(cookie));

        //  7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookieSet.contains("skin"));

        //   8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet=driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());



    }
}
