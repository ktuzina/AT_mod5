package com.training.task.module5.steps;

import com.training.task.module5.factory.WebDriverFactory;
import com.training.task.module5.utils.FilesHandler;
import com.training.task.module5.utils.PropertyHandler;
import com.training.task.module5.utils.WaitUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;
    private WebDriverFactory factory = new WebDriverFactory("chrome");

    @Before
    public void openProductPage() {
        FilesHandler.cleanDownloadDirectory();
        driver = factory.getDriver();
        driver.get(PropertyHandler.getTestUrl());
        WaitUtils.sleepSomeSecs();
    }

    @After
    public void closeBrowser() {
        factory.killDriver();
    }
}
