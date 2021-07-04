package com.training.task.module5.factory;

import com.training.task.module5.utils.Constants;
import com.training.task.module5.utils.Log;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class ChromeDriverCreator extends WebDriverCreator {
    @Override
    public WebDriver createDriver() {

        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", Constants.DOWNLOAD_PATH);
        prefs.put("plugins.always_open_pdf_externally", true);

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.setCapability("platform", Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        } catch (MalformedURLException e) {
            Log.error("Failed to create driver for Chrome browser");
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        return driver;
    }
}
