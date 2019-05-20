package com.training.task.module5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends AbstractPage {

    private static String OPTIONS_PATH = "//main[@id='maincontent']//span[@class='icon icon-more-vertical']";
    private static String CLONE_BTN_PATH = "//main[@id='maincontent']//button[@id='clone-style-btn']";
    private static String PDF_DOWNLOAD_BTN_ID = "w2b-simple-pdf-btn";
    private static String ADD_TO_CART_BTN_PATH = "//aside[contains(@class, 'simplepdf-modal')]//*[@class='modal-footer']//button[1]";
    private static String PROCEED_CHECKOUT_BTN_CLASS = "proceed-checkout";
    private static String LOADING_ELEMENT_PATH = "//div[@class=\'loader\']/img";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void createClone() {
        WebElement options = driver.findElement(By.xpath(OPTIONS_PATH));
        options.click();
        WebElement cloneBtn = driver.findElement(By.xpath(CLONE_BTN_PATH));
        cloneBtn.click();
//        пожалуйста переделай локатор
        WebElement createCloneBtn = driver.findElement(By.xpath("/html/body/div[3]/aside[1]/div[2]/footer/button[1]"));
        createCloneBtn.click();
    }

    public void putToCartViaPDFDownload() {
//        думаю изза этого ожидания можно зависнуть на долго))
        WebDriverWait wait = new WebDriverWait(driver, 800, 1000);

        WebElement loadingElement = driver.findElement(By.xpath(LOADING_ELEMENT_PATH));
        wait.until(ExpectedConditions.invisibilityOf(loadingElement));

        WebElement pdfDownloadBtn = driver.findElement(By.id(PDF_DOWNLOAD_BTN_ID));
        wait.until(ExpectedConditions.elementToBeClickable(pdfDownloadBtn));
        pdfDownloadBtn.click();
        WebElement addToCartBtn = driver.findElement(By.xpath(ADD_TO_CART_BTN_PATH));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();
        WebElement proceedCheckoutBtn = driver.findElement(By.className(PROCEED_CHECKOUT_BTN_CLASS));
        wait.until(ExpectedConditions.elementToBeClickable(proceedCheckoutBtn));
        proceedCheckoutBtn.click();
    }
}
