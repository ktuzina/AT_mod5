package com.training.task.module5.factory;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverCreator {

    protected WebDriver driver;

    public abstract WebDriver createDriver();
}
