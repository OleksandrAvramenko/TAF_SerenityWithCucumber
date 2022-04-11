package com.udemy.spring.springseleniummy.steps;

import com.udemy.spring.springseleniummy.pages.login.LoginPage;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.udemy.spring.springseleniummy.core.service.UserManager.UserType;
import static com.udemy.spring.springseleniummy.core.service.UserManager.getUser;
import static com.udemy.spring.springseleniummy.enums.Props.HOST_URL;
import static org.assertj.core.api.Assertions.assertThat;

@Component
public class LoginSteps {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomeSteps homeSteps;

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