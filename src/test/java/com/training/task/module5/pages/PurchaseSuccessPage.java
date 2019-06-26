package com.training.task.module5.pages;

import com.training.task.module5.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseSuccessPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='order-details']//a")
    private WebElement orderNumber;

    @FindBy(xpath = "//div[@class='loader']/img")
    private WebElement loadingElement;


    public PurchaseSuccessPage(WebDriver driver) {
        super(driver);
    }

    public OrderPage goToOrderDetails() {
        BrowserUtils.click(orderNumber, driver);
        return new OrderPage(driver);
    }
}
