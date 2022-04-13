package pages;

import driver.DriverSession;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public abstract class AbstractBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected void init() {
        this.driver = DriverSession.getDriver();
        this.wait = DriverSession.getDriverWait();
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isPageOpened();
}
