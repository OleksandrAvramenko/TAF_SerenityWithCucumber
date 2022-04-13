package pages;

import driver.DriverSession;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent extends AbstractBasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @Override
    protected void init() {
        this.driver = DriverSession.getDriver();
        this.wait = DriverSession.getDriverWait();
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();

    @Override
    public boolean isPageOpened() {
        return true;
    }
}
