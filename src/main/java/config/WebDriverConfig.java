package config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverConfig {

    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public WebDriverWait webDriverWait(final WebDriver driver) {
        return new WebDriverWait(driver, 10);
    }
}
