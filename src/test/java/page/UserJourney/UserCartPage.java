package page.UserJourney;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class UserCartPage {
    private Page page;
    public UserCartPage(Page page){
        this.page = page;
    }

    public void verifyItemDescription(String itemDescription){
        assertThat(page.locator("//p[contains(@class,'prodcut__title')]")).hasText(itemDescription);
    }
}
