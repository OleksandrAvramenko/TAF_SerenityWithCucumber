package packages.steps;

import core.service.UserManager;
import core.service.UserManager.UserType;
import models.User;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;
import pages.login.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps extends ScenarioSteps {

    @Page
    private LoginPage loginPage;

    @Step
    public void verifyLoginPageIsOpened() {
        assertThat(loginPage.isPageOpened())
                .withFailMessage(() -> "The Login Page is NOT opened.")
                .isTrue();
    }

    @Step
    public void inputSpecificUserCredentials(final UserType userType) {
        User user = UserManager.getUser(userType);
        loginPage.getUsernameInput().type(user.getUsername());
        loginPage.getPasswordInput().type(user.getPassword());
    }

    @Step
    public void clickLoginButton() {
        loginPage.getLoginButton().click();
    }

    public String getLoginMessageText() {
        return loginPage.getLoginErrorMessage().getText();
    }
}