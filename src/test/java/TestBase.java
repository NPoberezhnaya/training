import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    protected WebDriver driver;
   // private static WebDriver driver;
    private static String baseUrl;
    private static boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
       // driver = new InternetExplorerDriver();







        baseUrl = "http://localhost/litecart/";

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);






    }
    protected   boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void openMainPage() {
        driver.get(baseUrl + "admin/");
    }
    protected void openShopPage() {
        driver.get(baseUrl);
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



    protected WebElement find(String locator, int index) {
        return  driver.findElements(By.cssSelector(locator)).get(index);
    }
    protected int findSize(String locator) {
        return  driver.findElements(By.cssSelector(locator)).size();
    }
    protected void click(String locator, int index) {
        find(locator, index).click();
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


