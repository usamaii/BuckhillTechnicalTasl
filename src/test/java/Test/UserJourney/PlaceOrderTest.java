package Test.UserJourney;

import Util.TestBase;
import org.testng.annotations.Test;
import page.UserJourney.UserCheckoutPage;
import page.UserJourney.UserHomePage;
import page.UserJourney.UserItemDetailsPage;
import page.UserJourney.UserLoginPage;

public class PlaceOrderTest extends TestBase {

    @Test
    public void verifyUserCanPlaceOrderWithOneItem(){
        //This will automate the process of placing an order with one item
        UserLoginPage userLoginPage = new UserLoginPage(userPage);
        userPage = userLoginPage.loginToPetShop();

        UserHomePage userHomePage = new UserHomePage(userPage);
        userPage = userHomePage.clickItemFromList1(1);

        UserItemDetailsPage userItemDetailsPage = new UserItemDetailsPage(userPage);
        userItemDetailsPage.addItemToCart();
        userPage = userItemDetailsPage.clickBtnProceedToCheckOut();

        UserCheckoutPage userCheckoutPage = new UserCheckoutPage(userPage);
        userCheckoutPage.completeShippingDetailsStep();
        userCheckoutPage.completePaymentDetailsStep();
        userCheckoutPage.placeOrder();
    }
}
