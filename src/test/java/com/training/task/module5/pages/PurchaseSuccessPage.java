package com.training.task.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseSuccessPage extends AbstractPage {

    private static final String ORDER_NUMBER_PATH = "//div[@class='order-details']//a";
    private static final String LOADING_ELEMENT_PATH = "//div[@class='loader']/img";

    @FindBy(xpath = ORDER_NUMBER_PATH)
    private WebElement orderNumber;

    @FindBy(xpath = LOADING_ELEMENT_PATH)
    private WebElement loadingElement;


    public PurchaseSuccessPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage goToOrderDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
        //wait.until(ExpectedConditions.invisibilityOf(loadingElement));
        wait.until(ExpectedConditions.elementToBeClickable(orderNumber)).click();
        return new OrderPage(driver);
    }
}
