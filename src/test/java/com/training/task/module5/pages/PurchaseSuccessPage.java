package com.training.task.module5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseSuccessPage extends AbstractPage {

    private static String ORDER_NUMBER_PATH = "//div[@class='order-details']//a";
    private static String LOADING_ELEMENT_PATH = "//div[@class='loader']/img";

    public PurchaseSuccessPage(WebDriver driver) {
        super(driver);
    }

    public void goToOrderDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 15, 1000);

        WebElement loadingElement = driver.findElement(By.xpath(LOADING_ELEMENT_PATH));
        wait.until(ExpectedConditions.invisibilityOf(loadingElement));

        WebElement orderNumber = driver.findElement(By.xpath(ORDER_NUMBER_PATH));
        wait.until(ExpectedConditions.elementToBeClickable(orderNumber));
        orderNumber.click();
    }
}
