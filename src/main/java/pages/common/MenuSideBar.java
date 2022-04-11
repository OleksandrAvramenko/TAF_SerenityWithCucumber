package pages.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import pages.AbstractComponent;

public class MenuSideBar extends AbstractComponent {

    public MenuSideBar(final WebDriver driver) {
        init(driver);
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Getter
    @AllArgsConstructor
    public enum MenuItems {
        ALL_ITEMS("All Items"),
        ABOUT("About"),
        LOGOUT("Logout"),
        RESET_APP_STATE("Reset App State");

        private String menuText;
    }


}
