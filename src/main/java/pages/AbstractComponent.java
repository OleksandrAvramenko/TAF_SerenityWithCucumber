package pages;

import core.driver.DriverSession;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public abstract class AbstractComponent {

    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverWait componentLoadWait;

    protected void init() {
        this.driver = DriverSession.getDriver();
        this.wait = DriverSession.getDriverWait();
        this.componentLoadWait = DriverSession.getPageLoadTimeout();
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isDisplayed();
}
