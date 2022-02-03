package pages.login;

import core.service.ConfigurationManager;
import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import pages.AbstractBasePage;

import java.time.Duration;

import static enums.Props.PAGE_LOAD_TIMEOUT;

@Getter
public class LoginPage extends AbstractBasePage {

    @FindBy(xpath = ".//input[@id='user-name']")
    private WebElementFacade usernameInput;

    @FindBy(xpath = ".//input[@id='password']")
    private WebElementFacade passwordInput;

    @FindBy(xpath = ".//input[@id='login-button']")
    private WebElementFacade loginButton;

    @FindBy(xpath = ".//h3[@data-test='error']")
    private WebElementFacade loginErrorMessage;

    @Override
    public boolean isPageOpened() {
        return withTimeoutOf(Duration.ofSeconds(Long.parseLong(ConfigurationManager.getProperty(PAGE_LOAD_TIMEOUT))))
                .waitFor(loginButton).isCurrentlyVisible();
    }
}