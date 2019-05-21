package com.training.task.module5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoxLibraryPage extends AbstractPage {

    private static String BOX_LIB_LINK_PATH = "//span[contains(text(), 'Box Library')]";
    private static String BOX_TEMPLATE_PATH = "//span[@class='name-wrapper']/span[contains(text(), 'Autotest template')]";

    public BoxLibraryPage(WebDriver driver) {
        super(driver);
    }

    public void openBoxLibrary() {
        WebElement boxLibLink = driver.findElement(By.xpath(BOX_LIB_LINK_PATH));
        boxLibLink.click();
    }

    public void selectBox() {
        WebElement boxTemplate = driver.findElement(By.xpath(BOX_TEMPLATE_PATH));
        boxTemplate.click();
    }
}
