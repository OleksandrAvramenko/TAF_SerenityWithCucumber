package com.udemy.spring.springseleniummy.pages.login;

import com.udemy.spring.springseleniummy.pages.AbstractBasePage;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Getter
@Component
public class LoginPage extends AbstractBasePage {

    @FindBy(xpath = ".//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = ".//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = ".//h3[@data-test='error']")
    private WebElement loginErrorMessage;

    @Override
    public boolean isPageOpened() {
        return getWait().until((driver) -> loginButton.isDisplayed());
    }
}