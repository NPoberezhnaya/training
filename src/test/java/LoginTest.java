import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static junit.framework.Assert.assertEquals;

public class LoginTest extends TestBase {

    @Test
    public void testLoginAdmin() throws Exception {
        openMainPage();
        LoginData newLoginData = new LoginData();
        newLoginData.loginName = "admin";
        newLoginData.pass = "admin";
        fillLoginForm(newLoginData);
        clickLogin();


    }



    @Test
    public void testStikerNew() throws Exception {

        openShopPage();
        int count = findSize(".product.column.shadow.hover-light");

     for (int i = 0; i < count; i++) {
        //   click(".product.column.shadow.hover-light", i);
         isElementPresent(By.className(".sticker.new"));

          //  sleep(500);
      int stickerNew = findSize(".sticker.new") ;

      assertEquals(stickerNew, 1);

      }
    }

    @Test
    public void testStickerSale() throws Exception {

        openShopPage();
        int count = findSize(".product.column.shadow.hover-light");

        for (int i = 0; i < count; i++) {
            //   click(".product.column.shadow.hover-light", i);

            //  sleep(500);

            int stickerSale = findSize(".sticker.sale");
            assertEquals(stickerSale, 1);

        }
    }


    @Test
    public void testHeader() throws Exception {

        openShopPage();
        int count = findSize("ul#box-apps-menu li#app-");

        for (int i = 0; i < count; i++) {
            click("ul#box-apps-menu li#app-", i);
            if (isElementPresent(By.tagName("h1"))) {  System.out.println("   !!!!!  "+ driver.findElement(By.tagName("h1")).getText());}
            sleep(500);

            if (findSize("ul#box-apps-menu li.selected ul li") != 0) {
                int internalCount = findSize("ul#box-apps-menu li.selected ul li");

                for (int c = 0; c < internalCount; c++) {
                    click("ul#box-apps-menu li.selected ul li", c);
                    if (isElementPresent(By.tagName("h1"))) {  System.out.println(driver.findElement(By.tagName("h1")).getText());}
                    sleep(500);
                }

            }
        }
    }



}