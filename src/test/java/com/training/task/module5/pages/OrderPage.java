package com.training.task.module5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage extends AbstractPage {

    private static String ORDER_STATUS_CLASS = "order-status";
    private static String PDF_1UP_BTN_PATH = "//div[@data-th='Actions']//button[1]";
    private static String CF2_1UP_BTN_PATH = "//div[@data-th='Actions']//button[2]";


    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageIsDisplayed() {
        WebElement orderStatus = driver.findElement(By.className(ORDER_STATUS_CLASS));

        return orderStatus.isDisplayed();
    }

    public void download1upPDF() {
        WebElement pdf1UpBtn = driver.findElement(By.xpath(PDF_1UP_BTN_PATH));
        pdf1UpBtn.click();
    }

    public void download1upCF2() {
        WebElement cf21UpBtn = driver.findElement(By.xpath(CF2_1UP_BTN_PATH));
        cf21UpBtn.click();
    }
}
