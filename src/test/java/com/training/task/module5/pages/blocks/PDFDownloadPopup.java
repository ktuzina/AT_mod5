package com.training.task.module5.pages.blocks;

import com.training.task.module5.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//aside[contains(@class, 'simplepdf-modal')]")
public class PDFDownloadPopup extends HtmlElement {

    @FindBy(xpath = ".//span[contains(text(), 'Add to Cart')]")
    private Button addToCart;

    @FindBy(xpath = ".//span[contains(text(), 'Cancel')]")
    private Button cancelPDFDownload;

    public void cancelAddToCart(WebDriver driver) {
        BrowserUtils.click(cancelPDFDownload, driver);
    }

    public void addToCart(WebDriver driver) {
        BrowserUtils.click(addToCart, driver);
    }

}
