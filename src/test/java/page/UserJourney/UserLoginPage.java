package page.UserJourney;

import Util.TestBase;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UserLoginPage {
    private Page page;
    public UserLoginPage(Page page){
        this.page = page;
    }

    public void clickLoginLgoutButton() {
        Locator btnLogin_Home = page.locator("//*[@id='__nuxt']/div/div/nav/header/div/div/div[3]/button[2]/span[3]");
        btnLogin_Home.click();
    }
    public void fillLoginFormEmailField(String email){
        Locator txtLoginFormEmail = page.locator("//div[@class='login__form elevation-2']/div[2]/div[1]/div/div[3]/input");
        txtLoginFormEmail.fill(email);
    }
    public void fillLoginFormPasswordField(String password){
        Locator txtLoginFormPassword = page.locator("//div[@class='login__form elevation-2']/div[3]/div[1]/div/div[3]/input");
        txtLoginFormPassword.fill(password);
    }
    public  void clickLoginFormLoginButton(){
        Locator btnLoginFormLogin = page.locator("//div[@class='login__form elevation-2']/button");
        btnLoginFormLogin.click();
    }
    public Page loginToPetShop(){
        TestBase testBase = new TestBase();
        clickLoginLgoutButton();
        fillLoginFormEmailField(testBase.userEmail);
        fillLoginFormPasswordField(testBase.userPassword);
        clickLoginFormLoginButton();
        return page;
    }


    public void verifyLoginPageItems(){
        Locator imgPetShopLogo = page.locator("//img[@alt='Pet logo']");
        Locator txtLoginFormEmail = page.locator("//div[@class='login__form elevation-2']/div[2]/div[1]/div/div[3]/input");
        Locator txtLoginFormPassword = page.locator("//div[@class='login__form elevation-2']/div[3]/div[1]/div/div[3]/input");
        Locator chkRememberMe = page.locator("//div[@class='login__form elevation-2']/div[4]/div[1]/div/div/div/input");
        Locator btnLoginFormLogin = page.locator("//div[@class='login__form elevation-2']/button");
        Locator divAuthActions = page.locator("//div[@class='auth-actions']/span");

        assertThat(imgPetShopLogo).isVisible();
        assertThat(txtLoginFormEmail).isVisible();
        assertThat(txtLoginFormPassword).isVisible();
        assertThat(chkRememberMe).isVisible();
        assertThat(chkRememberMe).not().isChecked();
        assertThat(btnLoginFormLogin).isVisible();
        assertThat(divAuthActions.first()).hasText("Forgot password?");
        assertThat(divAuthActions.nth(1)).hasText("Don't have an account? Sign up");
    }

    public void verifyInvalidLoginAttempt() {
        Locator pLoginError = page.locator("//p[text()[normalize-space()='{ \"success\": 0, \"data\": [], \"error\": \"Failed to authenticate user\", \"errors\": [], \"trace\": [] }']]");

        clickLoginLgoutButton();
        fillLoginFormEmailField("invalidemail@invaliddomain.com");
        fillLoginFormPasswordField("invalidpassword");
        clickLoginFormLoginButton();
        assertThat(pLoginError).isVisible();
    }


    public void verifyValidLoginAttempt(String email, String password) {
        Locator btnLogin_Home = page.locator("//*[@id='__nuxt']/div/div/nav/header/div/div/div[3]/button[2]/span[3]");

        clickLoginLgoutButton();
        fillLoginFormEmailField(email);
        fillLoginFormPasswordField(password);
        clickLoginFormLoginButton();
        assertThat(btnLogin_Home).hasText("LOGOUT");
    }

    public void verifyLogout() {
        Locator btnLogin_Home = page.locator("//*[@id='__nuxt']/div/div/nav/header/div/div/div[3]/button[2]/span[3]");

        clickLoginLgoutButton();
        assertThat(btnLogin_Home).hasText("LOGIN");
    }
}
