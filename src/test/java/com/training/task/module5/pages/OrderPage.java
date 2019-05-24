package com.training.task.module5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderPage extends AbstractPage {

    private static final String ORDER_STATUS_CLASS = "order-status";
    private static final String PDF_1UP_BTN_PATH = "//div[@data-th='Actions']//button[1]";
    private static final String CF2_1UP_BTN_PATH = "//div[@data-th='Actions']//button[2]";

    @FindBy(className = ORDER_STATUS_CLASS)
    private WebElement orderStatus;

    @FindBy(xpath = PDF_1UP_BTN_PATH)
    private WebElement pdf1UpBtn;

    @FindBy(xpath = CF2_1UP_BTN_PATH)
    private WebElement cf21UpBtn;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageIsDisplayed() {
        return orderStatus.isDisplayed();
    }

    public void download1upPDF() {
        pdf1UpBtn.click();
    }

    public void download1upCF2() {
        cf21UpBtn.click();
    }

    public boolean download1upPDFisVisible() {
        try {
            new WebDriverWait(driver, 15, 1000)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(PDF_1UP_BTN_PATH)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean download1upCF2isVisible() {
        try {
            new WebDriverWait(driver, 15, 1000)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(CF2_1UP_BTN_PATH)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
