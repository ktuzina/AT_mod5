package com.training.task.module5.pages;

import com.training.task.module5.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseSuccessPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='order-details']//a")
    private WebElement orderNumber;

    @FindBy(xpath = "//div[@class='loader']/img")
    private WebElement loadingElement;


    public PurchaseSuccessPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage goToOrderDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME);
        //wait.until(ExpectedConditions.invisibilityOf(loadingElement));
        wait.until(ExpectedConditions.elementToBeClickable(orderNumber)).click();
        return new OrderPage(driver);
    }
}
