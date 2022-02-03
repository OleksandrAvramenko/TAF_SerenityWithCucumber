package pages.home;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import pages.AbstractBasePage;
import pages.common.MenuSideBar;

@Getter
public class HomePage extends AbstractBasePage {

    private ProductItemGrid productItemGrid;
    private MenuSideBar menuSideBar;

    @FindBy(xpath = ".//button[contains(@id, 'menu-btn')]")
    private WebElementFacade menuIcon;

    @FindBy(xpath = ".//div[@id='shopping_cart_container']")
    private WebElementFacade cartIcon;

    @FindBy(xpath = ".//span[@class='shopping_cart_badge']")
    private WebElementFacade cartItemsBadge;

    @Override
    public boolean isPageOpened() {
        return productItemGrid.isDisplayed();
    }
}
