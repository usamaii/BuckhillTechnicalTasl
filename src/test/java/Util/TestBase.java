package Util;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.*;


public class TestBase {

    public String userEmail = "";
    public String password = "userpassword";
    public Playwright playwrite;
    public Browser browser;
    public Page userPage;
    public  Page adminPage;
  @BeforeMethod
    public void openBrowser(){
      playwrite = Playwright.create();
      browser = playwrite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      BrowserContext userBrowser = browser.newContext();
      BrowserContext adminBrowser = browser.newContext();
      userPage = userBrowser.newPage();
      adminPage = adminBrowser.newPage();
      adminPage.navigate("https://pet-shop.buckhill.com.hr/login");
      userPage.navigate("https://pet-shop.buckhill.com.hr/");

      getUserCredentials();

  }

    private void getUserCredentials() {
      Locator txtAdminLoginEmail = adminPage.locator("#input-0");
      Locator txtAdminLoginPassword = adminPage.locator("#input-2");
      Locator btnLogin = adminPage.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Log in"));
      Locator btnCustomers = adminPage.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Customers"));
      Locator locUserEmail = adminPage.locator("//*[@id=\"__nuxt\"]/div/div/div/main/div/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[2]");
      txtAdminLoginEmail.fill("admin@buckhill.co.uk");
      txtAdminLoginPassword.fill("admin");
      btnLogin.click();
      btnCustomers.click();
      userEmail = locUserEmail.innerText().trim();
    }

    @AfterMethod
    public void closeBrowser(){
      browser.close();
      playwrite.close();
  }

}
