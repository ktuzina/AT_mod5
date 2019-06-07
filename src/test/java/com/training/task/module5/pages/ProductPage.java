package com.training.task.module5.pages;

import com.training.task.module5.pages.blocks.AddedToCartPopup;
import com.training.task.module5.pages.blocks.ClonePopup;
import com.training.task.module5.pages.blocks.PDFDownloadPopup;
import com.training.task.module5.utils.Constants;
import com.training.task.module5.utils.CustomWebElement;
import com.training.task.module5.utils.JSUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage {

    private PDFDownloadPopup pdfDownloadPopup;
    private AddedToCartPopup addedToCartPopup;
    private ClonePopup clonePopup;

    @FindBy(xpath = "//main[@id='maincontent']//span[@class='icon icon-more-vertical']")
    private WebElement options;

    @FindBy(id = "w2b-simple-pdf-btn")
    private WebElement pdfDownloadBtn;

    @FindBy(xpath = "//div[@class=\'loader\']/img")
    private WebElement loadingElement;

    public ProductPage(WebDriver driver) {
        super(driver);
        pdfDownloadBtn = new CustomWebElement(pdfDownloadBtn, driver);
    }

    public boolean pageIsDisplayed() {
        return pdfDownloadBtn.isDisplayed();
    }

    public void createClone() {
        options.click();
        JSUtils jsUtils = new JSUtils(driver);
        jsUtils.clickCloneBtn();
        clonePopup.confirmCloneCreation(driver);
        new WebDriverWait(driver, Constants.LONG_WAIT_TIME, Constants.CHECK_INTERVAL_TIME)
                .until(ExpectedConditions.invisibilityOf(loadingElement));
    }

    public ReviewPaymentsPage putToCartViaPDFDownload() {
        createClone();
        WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(pdfDownloadBtn)).click();
        pdfDownloadPopup.addToCart(driver);
        addedToCartPopup.proceedToCheckout(driver);

        return new ReviewPaymentsPage(driver);
    }

    public ProductPage cancelPutToCartViaPDFDownload() {
        createClone();
        WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(pdfDownloadBtn));
        pdfDownloadBtn.click();
        pdfDownloadPopup.cancelAddToCart(driver);
        return this;
    }

}
