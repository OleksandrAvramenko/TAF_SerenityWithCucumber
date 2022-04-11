package packages.steps;

import pages.home.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeSteps {

    private HomePage homePage = new HomePage();

    public HomeSteps verifyHomePageIsOpened() {
        assertThat(homePage.isPageOpened()).isTrue();
        return this;
    }

    public HomeSteps verifyProductItemGridIsDisplayed() {
        assertThat(homePage.getProductItemGrid().isDisplayed()).isTrue();
        return this;
    }

    public HomeSteps verifyProductItemGridSize(final int size) {
        assertThat(homePage.getProductItemGrid().getProductItems().size()).isEqualTo(size);
        return this;
    }

    public HomeSteps addItemWithSpecificNameToCart(final String itemName) {
        homePage.getProductItemGrid().getAddToCartButtonByItemName(itemName).click();
        return this;
    }

    public HomeSteps verifyCartBadgeCount(final String text) {
        assertThat(homePage.getCartItemsBadge().getText()).isEqualTo(text);
        return this;
    }
}
