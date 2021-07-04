package com.training.task.module5.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtils {

    private JavascriptExecutor js;
    private WebDriver driver;
    private String bgColor;

    public JSUtils(WebDriver driver) {
        this.driver = driver;
        this.js = ((JavascriptExecutor) driver);
    }

    public void clickCloneBtn(){
        js.executeScript("document.getElementById('clone-style-btn').click()");
    }

    public void highlightElement(WebElement element) {
        bgColor = element.getCssValue("backgroundColor");
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        WaitUtils.sleepSomeSecs();
    }

    public void unhighlightElement(WebElement element) {
        js.executeScript("arguments[0].style.backgroundColor = '" + bgColor + "'", element);
    }
}
