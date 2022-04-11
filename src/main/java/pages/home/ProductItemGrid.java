package pages.home;

import pages.AbstractComponent;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Component
public class ProductItemGrid extends AbstractComponent {

    private String productItemXpathByNameMask = ".//div[(@class='inventory_item_name') and contains(text(),'%s')]//ancestor::div[@class='inventory_item']";

    private String itemNameXpath = ".//div[@class='inventory_item_name']";

    private String itemDescriptionXpath = ".//div[@class='inventory_item_desc']";

    private String itemPriceXpath = ".//div[@class='inventory_item_price']";

    private String addToCartButtonXpath = ".//button[contains(@id, 'add')]";

    private String removeFromCartButtonXpath = ".//button[contains(@id, 'remove')]";

    @FindBy(xpath = ".//div[@id='inventory_container']")
    private WebElement inventoryContainer;

    @FindBy(xpath = ".//div[@class='inventory_item']")
    private List<WebElement> productItems;

    public WebElement getProductItemByName(final String name) {
        return getDriver()
                .findElement(By.xpath(String.format(productItemXpathByNameMask, name)));
    }

    public WebElement getAddToCartButtonByItemName(final String name) {
        return getProductItemByName(name).
                findElement(By.xpath(addToCartButtonXpath));
    }

    @Override
    public boolean isDisplayed() {
        return getWait().until((driver) -> inventoryContainer.isDisplayed());
    }
}
