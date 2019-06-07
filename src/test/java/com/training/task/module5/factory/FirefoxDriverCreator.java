package com.training.task.module5.factory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxDriverCreator extends WebDriverCreator {
    @Override
    public WebDriver createDriver() {
        System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("platform", Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
