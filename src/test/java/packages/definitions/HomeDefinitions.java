package packages.definitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import packages.steps.HomeSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeDefinitions {

    @Steps
    private HomeSteps homeSteps;

    @Then("Home Page is opened")
    public void verifyHomePageIsOpened() {
        assertThat(homeSteps.isPageOpened()).isTrue();
    }

    @Then("Product Item Grid is displayed")
    public void productItemGridIsDisplayed() {
        assertThat(homeSteps.verifyProductItemGridIsDisplayed()).isTrue();
    }

    @Then("Product Item Grid size equals {int}")
    public void productItemGridSizeEquals(final int size) {
        assertThat(homeSteps.getProductItemGridSize()).isEqualTo(size);
    }

    @When("I add item with {string} name to Cart")
    public void addItemWithSpecificNameToCart(final String itemName) {
        homeSteps.addItemWithSpecificNameToCart(itemName);
    }

    @Then("Cart Items Badge count equals {string}")
    public void cartBadgeCountEquals(final String text) {
        assertThat(homeSteps.getCartBadgeCountText()).isEqualTo(text);
    }
}
