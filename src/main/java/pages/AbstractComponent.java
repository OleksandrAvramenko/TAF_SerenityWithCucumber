package pages;

import config.WebDriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent extends AbstractBasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    protected void init(final WebDriver driver) {
        this.driver = driver;
        this.wait = WebDriverConfig.getWebDriverWait(driver);
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();

    @Override
    public boolean isPageOpened() {
        return true;
    }
}
