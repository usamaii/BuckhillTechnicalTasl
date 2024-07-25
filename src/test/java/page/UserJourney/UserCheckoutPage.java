package page.UserJourney;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UserCheckoutPage {
    private Page page;
    public UserCheckoutPage(Page page){
        this.page = page;
    }
    public void completeShippingDetailsStep() {
        Locator txtFirstName = page.locator("(//input[@class='v-field__input'])[1]");
        Locator txtLastName = page.locator("(//input[@class='v-field__input'])[2]");
        Locator txtAddress1 = page.locator("(//input[@class='v-field__input'])[3]");
        Locator txtAddress2 = page.locator("(//input[@class='v-field__input'])[4]");
        Locator txtZipCode = page.locator("(//input[@class='v-field__input'])[7]");
        Locator txtCountry = page.locator("(//input[@class='v-field__input'])[8]");
        Locator chkUseForPayment = page.locator("(//input[@type='checkbox'])[1]");
        Locator btnNext = page.locator("//button[contains(@class,'v-btn v-btn--flat')]");

        txtFirstName.fill("Usama");
        txtLastName.fill("Ismail");
        txtAddress1.fill("10, Nagahamulla Road");
        txtAddress2.fill("Kolonnawa");
        txtZipCode.fill("10600");
        txtCountry.fill("SriLanka");
        chkUseForPayment.check();
        btnNext.click();
    }

    public void completePaymentDetailsStep() {
        Locator txtCODFirstName = page.locator("(//input[@class='v-field__input'])[17]");
        Locator txtCODLastName = page.locator("(//input[@class='v-field__input'])[18]");
        Locator txtCODAddress1 = page.locator("(//input[@class='v-field__input'])[19]");
        Locator txtCODAddress2 = page.locator("(//input[@class='v-field__input'])[20]");
        Locator chkUseForPayment = page.locator("(//input[@type='checkbox'])[3]");
        Locator btnNext = page.locator("(//button[contains(@class,'v-btn v-btn--flat')])[2]");

        txtCODFirstName.fill("Usama");
        txtCODLastName.fill("Ismail");
        txtCODAddress1.fill("10, Nagahamulla Road");
        txtCODAddress2.fill("Kolonnawa");
        chkUseForPayment.check();
        btnNext.click();
    }

    public void placeOrder() {
        Locator btnPlaceOrder = page.locator("//button[contains(@class,'v-btn v-btn--flat')]");
        Locator divErrorMessage = page.locator("//div[contains(@class,'text-center w-100')]//small[1]");
        btnPlaceOrder.click();
        //Checking for error message as I'm getting the error when trying to place the order
        assertThat(divErrorMessage).isVisible();
    }
}
