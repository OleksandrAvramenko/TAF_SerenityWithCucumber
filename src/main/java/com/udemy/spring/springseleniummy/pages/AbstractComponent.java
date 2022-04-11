package com.udemy.spring.springseleniummy.pages;

public abstract class AbstractComponent extends AbstractBasePage {

    public abstract boolean isDisplayed();

    @Override
    public boolean isPageOpened() {
        return true;
    }
}
