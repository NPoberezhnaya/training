import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestBase {

    private static WebDriver driver;
    private static String baseUrl;
    private static boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = " http://localhost/litecart/";
    }


    protected void openMainPage() {
        driver.get(baseUrl + "admin/");
    }

    protected void fillLoginForm(LoginData loginData) {
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(loginData.loginName);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(loginData.pass);
    }

    protected void clickLogin() {
        driver.findElement(By.name("login")).click();
    }

    @AfterTest
    public void tearDown() throws Exception {
    driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }
    }

    }


