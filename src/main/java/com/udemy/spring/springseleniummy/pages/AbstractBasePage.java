package com.udemy.spring.springseleniummy.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Getter
public abstract class AbstractBasePage {

    @Autowired
    private WebDriver driver;

    @Autowired
    private WebDriverWait wait;

    @PostConstruct
    protected void init() {
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isPageOpened();
}
