package com.udemy.spring.springseleniummy.tests.smoke;

import com.udemy.spring.springseleniummy.FunctionalTest;
import com.udemy.spring.springseleniummy.core.service.UserManager;
import com.udemy.spring.springseleniummy.steps.HomeSteps;
import com.udemy.spring.springseleniummy.steps.LoginSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static com.udemy.spring.springseleniummy.core.service.UserManager.UserType.*;

public class ProductItemsTest extends FunctionalTest {

    @Autowired
    private LoginSteps loginSteps;

    @Autowired
    private HomeSteps homeSteps;

    private UserManager.UserType userManager;

    @Test
    public void verifyProductItemGridSize() {
        loginSteps
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened()
                .verifyProductItemGridIsDisplayed()
                .verifyProductItemGridSize(6);
    }

    @Test
    public void verifyAddToCardButton() {
        loginSteps
                .userIsOnSwagLabLoginPage()
                .loginWithSpecificCredentials(STANDARD_USER)
                .verifyHomePageIsOpened()
                .addItemWithSpecificNameToCart("Sauce Labs Backpack")
                .verifyCartBadgeCount("1");
    }
}
