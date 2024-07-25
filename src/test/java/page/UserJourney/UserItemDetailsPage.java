package page.UserJourney;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class UserItemDetailsPage {
    private Page page;
    public UserItemDetailsPage(Page page){
        this.page = page;
    }


    public void addItemToCart() {
        String itemDescription = page.locator(".product__title").textContent().trim();
        clickAddToCartButton();
        clickCartButton();
        UserCartPage userCartPage = new UserCartPage(page);
        userCartPage.verifyItemDescription(itemDescription);
    }

    private void clickCartButton() {
        Locator btnCart = page.locator("//div[@class='v-toolbar__content']/div/div[3]/button[1]");
        btnCart.click();
    }

    private void clickAddToCartButton() {
        Locator btnAddToCart = page.locator("//div[@class='product__actions-wrapper']//button[1]");
        btnAddToCart.click();
    }

    public Page clickBtnProceedToCheckOut() {
        Locator btnProceedToCheckout = page.locator("//button[contains(@class,'v-btn v-btn--elevated')]");
        btnProceedToCheckout.click();
        return page;
    }
}
