package com.training.task.module5.factory;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private static WebDriver driver;
    private static String browser;

    public WebDriverFactory(String browser) {
        this.browser = browser;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    public static WebDriver setDriver() {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverCreator creatorGHDriver = new ChromeDriverCreator();
            driver = creatorGHDriver.createDriver();
        } else {
            WebDriverCreator creatorFFDriver = new FirefoxDriverCreator();
            driver = creatorFFDriver.createDriver();
        }
        return driver;
    }

    public static void killDriver() {
        driver.quit();
        driver = null;
    }
}
