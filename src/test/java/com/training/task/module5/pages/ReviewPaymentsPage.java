package com.training.task.module5.pages;

import com.training.task.module5.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPaymentsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='checkout-payment-method-load']//span[contains(text(), 'No Payment')]")
    private WebElement moneyRadioBtn;

    @FindBy(xpath = "//div[contains(@class,'payment-method _active')]//button[@class='action primary checkout']")
    private WebElement placeOrderBtn;

    @FindBy(xpath = "//div[@class='loader']//img")
    private WebElement loadingElement;

    public ReviewPaymentsPage(WebDriver driver) {
        super(driver);
    }

    public PurchaseSuccessPage selectCheckMoneyPaymentMethod() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIME);

        wait.until(ExpectedConditions.elementToBeClickable(moneyRadioBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(placeOrderBtn)).click();

        return new PurchaseSuccessPage(driver);
    }
}
