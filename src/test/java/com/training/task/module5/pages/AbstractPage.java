package com.training.task.module5.pages;

import org.openqa.selenium.WebDriver;


public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
