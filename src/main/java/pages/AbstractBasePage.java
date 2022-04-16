package pages;

import core.driver.DriverSession;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public abstract class AbstractBasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverWait pageToLoadWait;

    protected void init() {
        this.driver = DriverSession.getDriver();
        this.wait = DriverSession.getDriverWait();
        this.pageToLoadWait = DriverSession.getPageLoadTimeout();
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isPageOpened();
}
