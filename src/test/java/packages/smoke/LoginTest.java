package packages.smoke;

import core.service.UserManager.UserType;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import packages.FunctionalTest;
import packages.steps.LoginSteps;

import static core.service.UserManager.UserType.*;
import static io.qameta.allure.SeverityLevel.*;

@Epic("Allure examples")
@Feature("Login")
public class LoginTest extends FunctionalTest {

    @Test
    @Severity(CRITICAL)
    @Story("TEST_001")
    public void verifySuccessfulLoginWithStandardUser() {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened();
    }

    @Test
    @Severity(CRITICAL)
    @Story("TEST_002")
    public void verifyLoginErrorMessageForLockedOutUser() {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .inputSpecificUserCredentials(LOCKED_OUT_USER)
                .clickLoginButton()
                .verifyLoginErrorMessageText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    @Severity(CRITICAL)
    @Story("TEST_001")
    public void verifyLoginErrorMessageWhenNoCredEntered() {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .clickLoginButton()
                .verifyLoginErrorMessageText("Epic sadface: Username is required");
    }

    @Test (dataProvider = "usersWithEmptyOneOfMandatoryField")
    @Severity(CRITICAL)
    @Story("TEST_001")
    public void verifyLoginErrorMessageWhenNotAllMandatoryFieldsEntered(final UserType user, final String message) {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .inputSpecificUserCredentials(user)
                .clickLoginButton()
                .verifyLoginErrorMessageText(message);
    }

    @DataProvider
    public static Object[][] usersWithEmptyOneOfMandatoryField() {
        return new Object[][] {
                {EMPTY_NAME_USER, "Epic sadface: Username is required"},
                {EMPTY_PASSWORD_USER, "Epic sadface: Password is required"}
        };
    }
}
