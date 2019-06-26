package com.training.task.module5.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class BrowserUtils {
    
    private static final String SCREENSHOTS_NAME_TPL = "screenshots/";
    private static JSUtils jsUtils;

    public static void click(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME)
                .until(ExpectedConditions.elementToBeClickable(element));
        Log.info("Clicking element '" + element.getText() + "'");
        jsUtils = new JSUtils(driver);
        jsUtils.highlightElement(element);
        jsUtils.unhighlightElement(element);
        element.click();

    }

    public static void takeScreenshot(WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
            Log.info("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
            Log.error("Failed to make screenshot");
        }
    }

}
