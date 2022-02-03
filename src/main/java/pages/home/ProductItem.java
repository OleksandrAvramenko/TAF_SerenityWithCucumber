package pages.home;

import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import pages.AbstractComponent;

@Getter
public class ProductItem extends AbstractComponent {

    @FindBy(xpath = ".//div[@class='inventory_item_name']")
    private WebElementFacade itemName;

    @FindBy(xpath = ".//div[@class='inventory_item_desc']")
    private WebElementFacade itemDescription;

    @FindBy(xpath = ".//div[@class='inventory_item_price']")
    private WebElementFacade itemPrice;

    @FindBy(xpath = ".//button[contains(@id, 'add')]")
    private WebElementFacade addToCartButton;

    @FindBy(xpath = ".//button[contains(@id, 'remove')]")
    private WebElementFacade removeFromCartButton;

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
