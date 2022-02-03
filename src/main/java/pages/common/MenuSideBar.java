package pages.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pages.AbstractComponent;

public class MenuSideBar extends AbstractComponent {

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
