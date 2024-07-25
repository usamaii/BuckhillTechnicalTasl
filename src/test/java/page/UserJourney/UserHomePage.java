package page.UserJourney;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class UserHomePage {
    private Page page;
    public UserHomePage(Page page){
        this.page = page;
    }


    public Page clickItemFromList1(int itemNumber) {
        Locator divItem = page.locator("(//div[@class='v-slide-group__content']//div)["+itemNumber+"]");
        divItem.click();
        return page;
    }
}
