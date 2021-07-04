package com.training.task.module5.pages;

import com.training.task.module5.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoxLibraryPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(), 'Box Library')]")
    private WebElement boxLibLink;

    @FindBy(xpath = "//span[@class='name-wrapper']/span[contains(text(), 'Autotest template')]")
    private WebElement boxTemplate;

    public BoxLibraryPage(WebDriver driver) {
        super(driver);
    }


    public ProductPage openLibraryAndSelectBox() {
        BrowserUtils.click(boxLibLink, driver);
        BrowserUtils.click(boxTemplate, driver);
        return new ProductPage(driver);
    }
}
