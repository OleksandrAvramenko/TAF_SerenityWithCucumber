package com.udemy.spring.springseleniummy.core.service;

import models.User;
import org.apache.commons.lang.NotImplementedException;

import java.util.Arrays;

import static com.udemy.spring.springseleniummy.enums.Props.LOCKED_OUT_USER_NAME;
import static com.udemy.spring.springseleniummy.enums.Props.LOCKED_OUT_USER_PASSWORD;
import static com.udemy.spring.springseleniummy.enums.Props.STANDARD_USER_NAME;
import static com.udemy.spring.springseleniummy.enums.Props.STANDARD_USER_PASSWORD;

public class UserManager {

    private UserManager() {
    }

    public static User getUser(final UserType userType) {
        User user;
        switch (userType) {
            case STANDARD_USER:
                user = new User(STANDARD_USER_NAME.getValue(), STANDARD_USER_PASSWORD.getValue());
                break;
            case LOCKED_OUT_USER:
                user = new User(LOCKED_OUT_USER_NAME.getValue(), LOCKED_OUT_USER_PASSWORD.getValue());
                break;
            case EMPTY_PASSWORD_USER:
                user = new User(STANDARD_USER_NAME.getValue(), "");
                break;
            case EMPTY_NAME_USER:
                user = new User("", STANDARD_USER_PASSWORD.getValue());
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
