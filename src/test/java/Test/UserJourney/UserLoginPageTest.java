package Test.UserJourney;

import Util.TestBase;
import org.testng.annotations.Test;
import page.UserJourney.UserLoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UserLoginPageTest extends TestBase {


    @Test
    public void verifyLoginPage() {
        UserLoginPage userLoginPage = new UserLoginPage(userPage);
        userLoginPage.clickLoginLgoutButton();
        userLoginPage.verifyLoginPageItems();
    }

    @Test
    public  void verifyLoginWithInvalidCredentials(){
        UserLoginPage userLoginPage = new UserLoginPage(userPage);
        userLoginPage.verifyInvalidLoginAttempt();
    }
    @Test
    public void verifyLoginWithValidCredentials(){
        UserLoginPage userLoginPage = new UserLoginPage(userPage);
        userLoginPage.verifyValidLoginAttempt(userEmail,userPassword);
    }
    @Test
    public void verifyLogout(){
        UserLoginPage userLoginPage = new UserLoginPage(userPage);
        userLoginPage.verifyLogout();
    }
}
