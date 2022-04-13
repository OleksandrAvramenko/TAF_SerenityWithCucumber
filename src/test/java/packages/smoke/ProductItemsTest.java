package packages.smoke;

import org.testng.annotations.Test;
import packages.FunctionalTest;
import packages.steps.LoginSteps;

import static core.service.UserManager.UserType.STANDARD_USER;

public class ProductItemsTest extends FunctionalTest {

    @Test
    public void verifyProductItemGridSize() {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened()
                .verifyProductItemGridIsDisplayed()
                .verifyProductItemGridSize(6);
    }

    @Test
    public void verifyAddToCardButton() {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened()
                .addItemWithSpecificNameToCart("Sauce Labs Backpack")
                .verifyCartBadgeCount("1");
    }
}
