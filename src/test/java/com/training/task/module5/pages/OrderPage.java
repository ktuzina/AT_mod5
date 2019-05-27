package com.training.task.module5.pages;

import com.training.task.module5.utils.Constants;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderPage extends AbstractPage {

    @FindBy(className = "order-status")
    private WebElement orderStatus;

    @FindBy(xpath = "//div[@data-th='Actions']//button[1]")
    private WebElement pdf1UpBtn;

    @FindBy(xpath = "//div[@data-th='Actions']//button[2]")
    private WebElement cf21UpBtn;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageIsDisplayed() {
        return orderStatus.isDisplayed();
    }

    public void download1upPDF() {
        pdf1UpBtn.click();
    }

    public void download1upCF2() {
        cf21UpBtn.click();
    }

    public boolean download1upPDFisVisible() {
        try {
            new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME)
                    .until(ExpectedConditions.elementToBeClickable(pdf1UpBtn));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean download1upCF2isVisible() {
        try {
            new WebDriverWait(driver, Constants.WAIT_TIME, Constants.CHECK_INTERVAL_TIME)
                    .until(ExpectedConditions.elementToBeClickable(cf21UpBtn));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
