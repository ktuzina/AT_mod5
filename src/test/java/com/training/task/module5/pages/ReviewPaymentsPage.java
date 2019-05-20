package com.training.task.module5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPaymentsPage extends AbstractPage {

    private static String CHECK_MONEY_RADIOBTN_PATH = "//*[@id='checkout-payment-method-load']/div/div/div[5]/div[1]/label/span";
    private static String PLACE_ORDER_BTN_PATH = "//div[contains(@class,'payment-method _active')]//button[@class='action primary checkout']";
    private static String LOADING_ELEMENT_PATH = "//div[@class='loader']/img";

    public ReviewPaymentsPage(WebDriver driver) {
        super(driver);
    }

    public void selectCheckMoneyPaymentMethod() {
        WebDriverWait wait = new WebDriverWait(driver, 15, 1000);

        WebElement loadingElement = driver.findElement(By.xpath(LOADING_ELEMENT_PATH));
        wait.until(ExpectedConditions.invisibilityOf(loadingElement));

        WebElement moneyRadioBtn = driver.findElement(By.xpath(CHECK_MONEY_RADIOBTN_PATH));
        wait.until(ExpectedConditions.elementToBeClickable(moneyRadioBtn));
        moneyRadioBtn.click();

        WebElement placeOrderBtn = driver.findElement(By.xpath(PLACE_ORDER_BTN_PATH));

        wait.until(ExpectedConditions.visibilityOf(placeOrderBtn));
        placeOrderBtn.click();
    }
}
