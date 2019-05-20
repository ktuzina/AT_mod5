package com.training.task.module5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoxLibraryPage extends AbstractPage {

    private static String BOX_LIB_LINK_PATH = "/html/body/div[2]/div[1]/div/div[2]/nav/div/ul/li[2]/a/span";
    private static String BOX_TEMPLATE_PATH = "/html/body/div[2]/main/div/div[1]/div[6]/div/div[2]/ol/li[1]/div/div[2]/div/div/a";

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
