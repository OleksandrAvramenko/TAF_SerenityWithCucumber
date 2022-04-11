package pages.home;

import pages.AbstractComponent;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductItem extends AbstractComponent {

    @FindBy(xpath = ".//div[@class='inventory_item_name']")
    private WebElement itemName;

    @FindBy(xpath = ".//div[@class='inventory_item_desc']")
    private WebElement itemDescription;

    @FindBy(xpath = ".//div[@class='inventory_item_price']")
    private WebElement itemPrice;

    @FindBy(xpath = ".//button[contains(@id, 'add')]")
    private WebElement addToCartButton;

    @FindBy(xpath = ".//button[contains(@id, 'remove')]")
    private WebElement removeFromCartButton;

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
