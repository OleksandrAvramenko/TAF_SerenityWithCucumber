package packages.definitions;

import core.service.UserManager;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import packages.steps.CommonSteps;
import packages.steps.LoginSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginDefinitions {

    @Steps
    private CommonSteps commonSteps;
    @Steps
    private LoginSteps loginSteps;

    @Given("User is on SwagLab Login Page")
    public void userIsOnSwagLabLoginPage() {
        System.out.println("The User is on SwagLab Login Page");
        commonSteps.navigateToBaseUrl();
        loginSteps.verifyLoginPageIsOpened();
    }

    @When("User clicks LOGIN button")
    public void clickLoginButton() {
        loginSteps.clickLoginButton();
    }

    @When("User login with '$userType' credentials")
    public void loginSpecificUserCredentials(final UserManager.UserType userType) {
        loginSteps.inputSpecificUserCredentials(userType);
        clickLoginButton();
    }

    @Then("Login Error Message contains text '$message'")
    public void verifyLoginErrorMessageText(final String message) {
        assertThat(loginSteps.getLoginMessageText()).contains(message);
    }
}
