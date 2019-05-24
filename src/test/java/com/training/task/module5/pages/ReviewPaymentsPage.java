package com.training.task.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewPaymentsPage extends AbstractPage {

    private static final String CHECK_MONEY_RADIOBTN_PATH = "//*[@id='checkout-payment-method-load']/div/div/div[5]/div[1]/label/span";
    private static final String PLACE_ORDER_BTN_PATH = "//div[contains(@class,'payment-method _active')]//button[@class='action primary checkout']";
    private static final String LOADING_ELEMENT_PATH = "//div[@class='loader']//img";

    @FindBy(xpath = CHECK_MONEY_RADIOBTN_PATH)
    private WebElement moneyRadioBtn;

    @FindBy(xpath = PLACE_ORDER_BTN_PATH)
    private WebElement placeOrderBtn;

    @FindBy(xpath = LOADING_ELEMENT_PATH)
    private WebElement loadingElement;

    public ReviewPaymentsPage(WebDriver driver) {
        super(driver);
    }

    public PurchaseSuccessPage selectCheckMoneyPaymentMethod() {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        //wait.until(ExpectedConditions.invisibilityOf(loadingElement));
        wait.until(ExpectedConditions.elementToBeClickable(moneyRadioBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(placeOrderBtn)).click();

        return new PurchaseSuccessPage(driver);
    }
}
