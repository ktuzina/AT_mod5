package com.training.task.module5.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class SetupDriver {

    private WebDriver driver;
    private String browser;

    public SetupDriver(String browser) {
        this.browser = browser;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    public void setDriver() {
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", Constants.DOWNLOAD_PATH);
        prefs.put("plugins.always_open_pdf_externally", true);

        try {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.setCapability("platform", Platform.WINDOWS);
                this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            } else {
                System.setProperty("webdriver.gecko.driver", "C:\\WebDriver\\geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("platform", Platform.WINDOWS);
                this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.driver.manage().window().maximize();
    }

}
