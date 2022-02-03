package packages.definitions;

import core.service.UserManager.UserType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
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

    @When("User login with '{}' credentials")
    public void loginSpecificUserCredentials(final UserType userType) {
        loginSteps.inputSpecificUserCredentials(userType);
        clickLoginButton();
    }


    @Then("Login Error Message contains text {string}")
    public void verifyLoginErrorMessageText(final String message) {
        assertThat(loginSteps.getLoginMessageText()).contains(message);
    }
}
