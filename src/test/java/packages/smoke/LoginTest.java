package packages.smoke;

import core.service.UserManager.UserType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import packages.FunctionalTest;
import packages.steps.LoginSteps;

import static core.service.UserManager.UserType.*;

public class LoginTest extends FunctionalTest {

    @Test
    public void verifySuccessfulLoginWithStandardUser() {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened();
    }

    @Test
    public void verifyLoginErrorMessageForLockedOutUser() {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .inputSpecificUserCredentials(LOCKED_OUT_USER)
                .clickLoginButton()
                .verifyLoginErrorMessageText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void verifyLoginErrorMessageWhenNoCredEntered() {
        new LoginSteps()
                .userIsOnSwagLabLoginPage()
                .clickLoginButton()
                .verifyLoginErrorMessageText("Epic sadface: Username is required");
    }

    @Test (dataProvider = "usersWithEmptyOneOfMandatoryField")
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
