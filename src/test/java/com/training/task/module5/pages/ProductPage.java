package com.training.task.module5.pages;

import com.training.task.module5.pages.blocks.AddedToCartPopup;
import com.training.task.module5.pages.blocks.ClonePopup;
import com.training.task.module5.pages.blocks.PDFDownloadPopup;
import com.training.task.module5.utils.*;
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
        BrowserUtils.click(options, driver);
        JSUtils jsUtils = new JSUtils(driver);
        jsUtils.clickCloneBtn();
        clonePopup.confirmCloneCreation(driver);
        new WebDriverWait(driver, Constants.LONG_WAIT_TIME, Constants.CHECK_INTERVAL_TIME)
                .until(ExpectedConditions.invisibilityOf(loadingElement));
        Log.debug("Clone is created");
    }

    public ReviewPaymentsPage putToCartViaPDFDownload() {
        createClone();
        openSimplePDFPopup();
        pdfDownloadPopup.addToCart(driver);
        addedToCartPopup.proceedToCheckout(driver);

        return new ReviewPaymentsPage(driver);
    }

    public ProductPage cancelPutToCartViaPDFDownload() {
        createClone();
        openSimplePDFPopup();
        cancelSimplePDF();
        return this;
    }

    public void openSimplePDFPopup() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME);
        Log.info("Clicking element '" + pdfDownloadBtn.getText() + "'");
        wait.until(ExpectedConditions.elementToBeClickable(pdfDownloadBtn)).click();
    }

    public void cancelSimplePDF() {
        pdfDownloadPopup.cancelAddToCart(driver);
    }

}
