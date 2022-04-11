package pages.home;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractComponent;

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

    public ProductItem(final WebDriver driver) {
        init(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }
}
