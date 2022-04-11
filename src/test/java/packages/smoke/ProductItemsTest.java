package packages.smoke;

import com.udemy.spring.springseleniummy.FunctionalTest;
import core.service.UserManager;
import packages.steps.HomeSteps;
import packages.steps.LoginSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static core.service.UserManager.UserType.*;

public class ProductItemsTest extends FunctionalTest {

    @Autowired
    private LoginSteps loginSteps;

    @Autowired
    private HomeSteps homeSteps;

    private UserManager.UserType userManager;

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
