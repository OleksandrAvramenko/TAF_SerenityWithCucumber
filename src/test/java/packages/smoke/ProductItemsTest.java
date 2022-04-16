package packages.smoke;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import packages.FunctionalTest;
import packages.steps.LoginSteps;

import static core.service.UserManager.UserType.STANDARD_USER;
import static io.qameta.allure.SeverityLevel.*;

@Epic("Allure examples")
@Feature("Product Item")
public class ProductItemsTest extends FunctionalTest {

    @Test
    @Severity(NORMAL)
    @Story("TEST_003")
    public void verifyProductItemGridSize() {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened()
                .verifyProductItemGridIsDisplayed()
                .verifyProductItemGridSize(6);
    }

    @Test
    @Severity(CRITICAL)
    @Story("TEST_004")
    @Story("TEST_005")
    public void verifyAddToCardButton() {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened()
                .addItemWithSpecificNameToCart("Sauce Labs Backpack")
                .verifyCartBadgeCount("1");
    }
}
