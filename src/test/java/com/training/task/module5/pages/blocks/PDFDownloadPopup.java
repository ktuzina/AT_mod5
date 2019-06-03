package com.training.task.module5.pages.blocks;

import com.training.task.module5.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//aside[contains(@class, 'simplepdf-modal')]")
public class PDFDownloadPopup extends HtmlElement {

    @FindBy(xpath = ".//span[contains(text(), 'Add to Cart')]")
    private Button addToCart;

    @FindBy(xpath = ".//span[contains(text(), 'Cancel')]")
    private Button cancelPDFDownload;

    public void cancelAddToCart(WebDriver driver) {
        new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME)
                .until(ExpectedConditions.elementToBeClickable(cancelPDFDownload)).click();
    }

    public void addToCart(WebDriver driver) {
        new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME)
                .until(ExpectedConditions.elementToBeClickable(addToCart)).click();
    }

}
