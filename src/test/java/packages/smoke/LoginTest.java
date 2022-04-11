package packages.smoke;

import core.service.UserManager.UserType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import packages.BaseTest;
import packages.steps.LoginSteps;

import static core.service.UserManager.UserType.*;


public class LoginTest extends BaseTest {

    private LoginSteps loginSteps;

    @BeforeTest
    public void setupTest() {
        loginSteps = new LoginSteps();
    }

    @Test
    public void verifySuccessfulLoginWithStandardUser() {
        loginSteps
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened();
    }

    @Test
    public void verifyLoginErrorMessageForLockedOutUser() {
        loginSteps
                .userIsOnSwagLabLoginPage()
                .inputSpecificUserCredentials(LOCKED_OUT_USER)
                .clickLoginButton()
                .verifyLoginErrorMessageText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void verifyLoginErrorMessageWhenNoCredEntered() {
        loginSteps
                .userIsOnSwagLabLoginPage()
                .clickLoginButton()
                .verifyLoginErrorMessageText("Epic sadface: Username is required");
    }

    @Test (dataProvider = "usersWithEmptyOneOfMandatoryField")
    public void verifyLoginErrorMessageWhenMotAllMandatoryFieldsEntered(final UserType user, final String message) {
        loginSteps
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
