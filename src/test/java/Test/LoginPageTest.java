package Test;

import Util.TestBase;
import com.microsoft.playwright.Locator;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageTest extends TestBase {
    @Test
    public void printUserPageTitle(){
        System.out.println(userEmail);
        System.out.println(password);
    }

    @Test
    public void verifyLoginPage() {
        Locator btnLogin_Home = userPage.locator("//*[@id='__nuxt']/div/div/nav/header/div/div/div[3]/button[2]/span[3]");
        Locator imgPetShopLogo = userPage.locator("//img[@alt='Pet logo']");
        Locator txtLoginFormEmail = userPage.locator("#input-25");
        Locator txtLoginFormPassword = userPage.locator("#input-27");
        Locator chkRememberMe = userPage.locator("#checkbox-29");
        Locator btnLoginFormLogin = userPage.locator("//div[@class='login__form elevation-2']/button");
        Locator divAuthActions = userPage.locator("//div[@class='auth-actions']/span");

        btnLogin_Home.click();
        assertThat(txtLoginFormEmail).isVisible();
        assertThat(imgPetShopLogo).isVisible();
        assertThat(txtLoginFormPassword).isVisible();
        assertThat(chkRememberMe).isVisible();
        assertThat(chkRememberMe).not().isChecked();
        assertThat(btnLoginFormLogin).isVisible();
        assertThat(divAuthActions.first()).hasText("Forgot password?");
        assertThat(divAuthActions.nth(1)).hasText("Don't have an account? Sign up");
     }
}
