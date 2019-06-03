package com.training.task.module5.pages;

import com.training.task.module5.utils.Constants;
import com.training.task.module5.utils.JSUtils;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//main[@id='maincontent']//span[@class='icon icon-more-vertical']")
    private WebElement options;

    @FindBy(xpath = "//span[contains(text(), 'Create Clone')]")
    private WebElement createCloneBtn;

    @FindBy(id = "w2b-simple-pdf-btn")
    private WebElement pdfDownloadBtn;

    @FindBy(xpath = "//aside[contains(@class, 'simplepdf-modal')]//span[contains(text(), 'Add to Cart')]")
    private WebElement addToCartBtn;

    @FindBy(className = "proceed-checkout")
    private WebElement proceedCheckoutBtn;

    @FindBy(xpath = "//div[@class=\'loader\']/img")
    private WebElement loadingElement;

    @FindBy(xpath = "//aside[contains(@class, 'simplepdf-modal')]//span[contains(text(), 'Cancel')]")
    private WebElement cancelPDFDownload;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageIsDisplayed() {
        return pdfDownloadBtn.isDisplayed();
    }

    public void createClone() {
        options.click();
        JSUtils jsUtils = new JSUtils(driver);
        jsUtils.clickCloneBtn();
        createCloneBtn.click();
        new WebDriverWait(driver, Constants.LONG_WAIT_TIME, Constants.CHECK_INTERVAL_TIME)
                .until(ExpectedConditions.invisibilityOf(loadingElement));
    }

    public ReviewPaymentsPage putToCartViaPDFDownload() {
        createClone();
        WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(pdfDownloadBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckoutBtn)).click();

        return new ReviewPaymentsPage(driver);
    }

    public ProductPage cancelPutToCartViaPDFDownload() {
        createClone();
        WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(pdfDownloadBtn));
        JSUtils jsUtils = new JSUtils(driver);
        jsUtils.highlightElement(pdfDownloadBtn);
        pdfDownloadBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(cancelPDFDownload)).click();
        return this;
    }

}
