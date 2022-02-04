package pages.home;

import core.service.ConfigurationManager;
import lombok.Getter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import pages.AbstractComponent;

import java.time.Duration;
import java.util.List;

import static enums.Props.PAGE_LOAD_TIMEOUT;

@Getter
public class ProductItemGrid extends AbstractComponent {

    private String productItemXpathByNameMask = ".//div[(@class='inventory_item_name') and contains(text(),'%s')]//ancestor::div[@class='inventory_item']";

    private String itemNameXpath = ".//div[@class='inventory_item_name']";

    private String itemDescriptionXpath = ".//div[@class='inventory_item_desc']";

    private String itemPriceXpath = ".//div[@class='inventory_item_price']";

    private String addToCartButtonXpath = ".//button[contains(@id, 'add')]";

    private String removeFromCartButtonXpath = ".//button[contains(@id, 'remove')]";

    @FindBy(xpath = ".//div[@id='inventory_container']")
    private WebElementFacade inventoryContainer;

    @FindBy(xpath = ".//div[@class='inventory_item']")
    private List<WebElementFacade> productItems;

    public WebElementFacade getProductItemByName(final String name) {
        return findBy(String.format(productItemXpathByNameMask, name));
    }

    public WebElementFacade getAddToCartButtonByItemName(final String name) {
        return getProductItemByName(name).findBy(addToCartButtonXpath);
    }

    @Override
    public boolean isDisplayed() {
        return withTimeoutOf(Duration.ofSeconds(Long.parseLong(ConfigurationManager.getProperty(PAGE_LOAD_TIMEOUT))))
                .waitFor(inventoryContainer).isCurrentlyVisible();
    }
}

