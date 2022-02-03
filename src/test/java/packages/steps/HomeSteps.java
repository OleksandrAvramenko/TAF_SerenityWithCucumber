package packages.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.fluentlenium.core.annotation.Page;
import pages.home.HomePage;

public class HomeSteps extends ScenarioSteps {

    @Page
    private HomePage homePage;

    public boolean isPageOpened() {
        return homePage.isPageOpened();
    }

    public int getProductItemGridSize() {
        return homePage.getProductItemGrid().getProductItems().size();
    }

    public boolean verifyProductItemGridIsDisplayed() {
        return homePage.getProductItemGrid().isDisplayed();
    }

    public String getCartBadgeCountText() {
        return homePage.getCartItemsBadge().getText();
    }

    @Step
    public void addItemWithSpecificNameToCart(final String itemName) {
        homePage.getProductItemGrid().getAddToCartButtonByItemName(itemName).click();
    }
}
