package packages.definitions;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
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

    @Then("Product Item Grid size equals '$gridSize'")
    public void productItemGridSizeEquals(final int size) {
        assertThat(homeSteps.getProductItemGridSize()).isEqualTo(size);
    }

    @When("I add item with '$itemName' name to Cart")
    public void addItemWithSpecificNameToCart(final String itemName) {
        homeSteps.addItemWithSpecificNameToCart(itemName);
    }

    @Then("Cart Items Badge count equals '$itemCount'")
    public void cartBadgeCountEquals(final String itemsCount) {
        assertThat(homeSteps.getCartBadgeCountText()).isEqualTo(itemsCount);
    }
}
