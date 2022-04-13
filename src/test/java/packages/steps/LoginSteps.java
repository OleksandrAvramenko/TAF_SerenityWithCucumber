package packages.steps;

import lombok.NoArgsConstructor;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.home.HomePage;
import pages.login.LoginPage;

import static core.service.UserManager.UserType;
import static core.service.UserManager.getUser;
import static enums.Props.HOST_URL;
import static org.assertj.core.api.Assertions.assertThat;

@NoArgsConstructor
public class LoginSteps {

    private LoginPage loginPage = new LoginPage();
    private HomeSteps homeSteps = new HomeSteps();

    public LoginSteps userIsOnSwagLabLoginPage() {
        navigateToBaseUrl();
        verifyLoginPageIsOpened();
        return this;
    }

    public LoginSteps navigateToBaseUrl() {
        loginPage.getDriver().get(HOST_URL.getValue());
        return this;
    }

    public LoginSteps verifyLoginPageIsOpened() {
        assertThat(loginPage.isPageOpened())
                .withFailMessage(() -> "The Login Page is NOT opened.")
                .isTrue();
        return this;
    }

    public LoginSteps inputSpecificUserCredentials(final UserType userType) {
        User user = getUser(userType);
        loginPage.getUsernameInput().sendKeys(user.getUsername());
        loginPage.getPasswordInput().sendKeys(user.getPassword());
        return this;
    }

    public LoginSteps clickLoginButton() {
        loginPage.getLoginButton().click();
        return this;
    }

    public HomeSteps loginWithSpecificCredentials(final UserType userType) {
        inputSpecificUserCredentials(userType);
        clickLoginButton();
        return homeSteps;
    }

    public LoginSteps verifyLoginErrorMessageText(final String message) {
        assertThat(loginPage.getLoginErrorMessage().getText()).contains(message);
        return this;
    }
}