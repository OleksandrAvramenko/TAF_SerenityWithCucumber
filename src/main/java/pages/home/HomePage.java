package pages.home;

import org.openqa.selenium.WebDriver;
import pages.AbstractBasePage;
import pages.common.MenuSideBar;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage extends AbstractBasePage {

    private ProductItemGrid productItemGrid;
    private MenuSideBar menuSideBar;

    @FindBy(xpath = ".//button[contains(@id, 'menu-btn')]")
    private WebElement menuIcon;

    @FindBy(xpath = ".//div[@id='shopping_cart_container']")
    private WebElement cartIcon;

    @FindBy(xpath = ".//span[@class='shopping_cart_badge']")
    private WebElement cartItemsBadge;

    public HomePage(final WebDriver driver) {
        init(driver);
        productItemGrid = new ProductItemGrid(driver);
        menuSideBar = new MenuSideBar(driver);
    }

    @Override
    public boolean isPageOpened() {
        return productItemGrid.isDisplayed();
    }
}
