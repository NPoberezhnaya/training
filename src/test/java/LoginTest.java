import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testLogin() throws Exception {

        openMainPage();
        LoginData newLoginData = new LoginData();
        newLoginData.loginName = "admin";
        newLoginData.pass = "admin";
        fillLoginForm(newLoginData);
        clickLogin();
    }


}