package Test;

import Util.TestBase;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    @Test
    public void printUserPageTitle(){
        System.out.println(userEmail);
        System.out.println(password);
    }
}
