package core.service;

import enums.Props;
import models.User;
import org.apache.commons.lang.NotImplementedException;

import java.util.Arrays;

import static enums.Props.LOCKED_OUT_USER_NAME;
import static enums.Props.LOCKED_OUT_USER_PASSWORD;
import static enums.Props.STANDARD_USER_PASSWORD;

public class UserManager {

    private UserManager() {
    }

    public static User getUser(final UserType userType) {
        User user;
        switch (userType) {
            case STANDARD_USER:
                user = new User(ConfigurationManager.getProperty(Props.STANDARD_USER_NAME), ConfigurationManager.getProperty(STANDARD_USER_PASSWORD));
                break;
            case LOCKED_OUT_USER:
                user = new User(ConfigurationManager.getProperty(LOCKED_OUT_USER_NAME), ConfigurationManager.getProperty(LOCKED_OUT_USER_PASSWORD));
                break;
            case EMPTY_PASSWORD_USER:
                user = new User(ConfigurationManager.getProperty(Props.STANDARD_USER_NAME), "");
                break;
            case EMPTY_NAME_USER:
                user = new User("", ConfigurationManager.getProperty(STANDARD_USER_PASSWORD));
                break;
            default:
                throw new NotImplementedException("Available UserTypes are -> " + Arrays.toString(UserType.values()));
        }
        return user;
    }

    public enum UserType {
        STANDARD_USER,
        LOCKED_OUT_USER,
        EMPTY_PASSWORD_USER,
        EMPTY_NAME_USER;
    }
}
