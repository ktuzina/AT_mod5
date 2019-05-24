package com.training.task.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage {

    private static final String OPTIONS_PATH = "//main[@id='maincontent']//span[@class='icon icon-more-vertical']";
    private static final String CLONE_BTN_PATH = "//main[@id='maincontent']//button[@id='clone-style-btn']";
    private static final String PDF_DOWNLOAD_BTN_ID = "w2b-simple-pdf-btn";
    private static final String ADD_TO_CART_BTN_PATH = "//aside[contains(@class, 'simplepdf-modal')]//span[contains(text(), 'Add to Cart')]";
    private static final String PROCEED_CHECKOUT_BTN_CLASS = "proceed-checkout";
    private static final String LOADING_ELEMENT_PATH = "//div[@class=\'loader\']/img";
    private static final String CREATE_CLONE_BTN_PATH = "//span[contains(text(), 'Create Clone')]";
    private static final String CANCEL_PDF_DOWNLOAD_PATH = "//aside[contains(@class, 'simplepdf-modal')]//span[contains(text(), 'Cancel')]";

    @FindBy(xpath = OPTIONS_PATH)
    private WebElement options;

    @FindBy(xpath = CLONE_BTN_PATH)
    private WebElement cloneBtn;

    @FindBy(xpath = CREATE_CLONE_BTN_PATH)
    private WebElement createCloneBtn;

    @FindBy(id = PDF_DOWNLOAD_BTN_ID)
    private WebElement pdfDownloadBtn;

    @FindBy(xpath = ADD_TO_CART_BTN_PATH)
    private WebElement addToCartBtn;

    @FindBy(className = PROCEED_CHECKOUT_BTN_CLASS)
    private WebElement proceedCheckoutBtn;

    @FindBy(xpath = LOADING_ELEMENT_PATH)
    private WebElement loadingElement;

    @FindBy(xpath = CANCEL_PDF_DOWNLOAD_PATH)
    private WebElement cancelPDFDownload;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageIsDisplayed() {
        return pdfDownloadBtn.isDisplayed();
    }

    public void createClone() {
        options.click();
        cloneBtn.click();
        createCloneBtn.click();
        new WebDriverWait(driver, 30, 1000)
                .until(ExpectedConditions.invisibilityOf(loadingElement));
    }

    public ReviewPaymentsPage putToCartViaPDFDownload() {
        createClone();
        WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(pdfDownloadBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckoutBtn)).click();

        return new ReviewPaymentsPage(driver);
    }

    public ProductPage cancelPutToCartViaPDFDownload() {
        createClone();
        WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(pdfDownloadBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cancelPDFDownload)).click();
        return this;
    }
}
