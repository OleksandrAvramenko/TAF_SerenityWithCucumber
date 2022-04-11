package com.udemy.spring.springseleniummy.steps;

import com.udemy.spring.springseleniummy.pages.home.HomePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.assertThat;

@Component
public class HomeSteps {

    @Autowired
    private HomePage homePage;

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
