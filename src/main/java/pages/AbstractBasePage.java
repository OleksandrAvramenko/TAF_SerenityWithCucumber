package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.PostConstruct;

@Getter
public abstract class AbstractBasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @PostConstruct
    protected void init() {
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isPageOpened();
}
