package com.udemy.spring.springseleniummy.pages.home;

import com.udemy.spring.springseleniummy.pages.AbstractBasePage;
import com.udemy.spring.springseleniummy.pages.common.MenuSideBar;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class HomePage extends AbstractBasePage {

    @Autowired
    private ProductItemGrid productItemGrid;

    @Autowired
    private MenuSideBar menuSideBar;

    @FindBy(xpath = ".//button[contains(@id, 'menu-btn')]")
    private WebElement menuIcon;

    @FindBy(xpath = ".//div[@id='shopping_cart_container']")
    private WebElement cartIcon;

    @FindBy(xpath = ".//span[@class='shopping_cart_badge']")
    private WebElement cartItemsBadge;

    @Override
    public boolean isPageOpened() {
        return productItemGrid.isDisplayed();
    }
}
