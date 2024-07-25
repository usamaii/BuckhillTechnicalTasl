package Util;

import com.microsoft.playwright.*;
import org.testng.annotations.*;


public class TestBase {

  public String userEmail = "usamaismail249@gmail.com";
  public String userPassword = "Asdf@1234";
  public String adminEmail = "admin@buckhill.co.uk";
  public String adminPassword = "admin";
  public Playwright playWrite;
  public Browser browser;
  public Page userPage;
  public  Page adminPage;
  @BeforeMethod
  public void openBrowser(){
    playWrite = Playwright.create();
    browser = playWrite.chromium().launch();
    BrowserContext userBrowser = browser.newContext();
    //BrowserContext adminBrowser = browser.newContext();
    userPage = userBrowser.newPage();
    //adminPage = adminBrowser.newPage();
    //adminPage.navigate("https://pet-shop.buckhill.com.hr/login");
    userPage.navigate("https://pet-shop.buckhill.com.hr/");
  }

  @AfterMethod
  public void closeBrowser(){
    browser.close();
    playWrite.close();
  }

}
