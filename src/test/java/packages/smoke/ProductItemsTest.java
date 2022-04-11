package packages.smoke;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import packages.BaseTest;
import packages.steps.LoginSteps;

import static core.service.UserManager.UserType.STANDARD_USER;

public class ProductItemsTest extends BaseTest {

    private LoginSteps loginSteps;

    @BeforeTest
    public void setupTest() {
        loginSteps = new LoginSteps();
    }

    @Test
    public void verifyProductItemGridSize() {
        loginSteps
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened()
                .verifyProductItemGridIsDisplayed()
                .verifyProductItemGridSize(6);
    }

    @Test
    public void verifyAddToCardButton() {
        loginSteps
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened()
                .addItemWithSpecificNameToCart("Sauce Labs Backpack")
                .verifyCartBadgeCount("1");
    }
}
