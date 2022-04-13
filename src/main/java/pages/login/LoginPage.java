package pages.login;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractBasePage;

@Getter
public class LoginPage extends AbstractBasePage {

    @FindBy(xpath = ".//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = ".//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = ".//input[@id='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = ".//h3[@data-test='error']")
    private WebElement loginErrorMessage;

    public LoginPage() {
        init();
    }

    @Override
    public boolean isPageOpened() {
        return getWait().until(driver -> loginButton.isDisplayed());
    }
}