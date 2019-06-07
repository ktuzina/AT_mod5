package com.training.task.module5.factory;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private WebDriver driver;
    private String browser;

    public WebDriverFactory(String browser) {
        this.browser = browser;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    public WebDriver setDriver() {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverCreator creatorGHDriver = new ChromeDriverCreator();
            driver = creatorGHDriver.createDriver();
        } else {
            WebDriverCreator creatorFFDriver = new FirefoxDriverCreator();
            driver = creatorFFDriver.createDriver();
        }
        return driver;
    }
}
