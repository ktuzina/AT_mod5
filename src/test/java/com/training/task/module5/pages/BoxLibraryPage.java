package com.training.task.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoxLibraryPage extends AbstractPage {

    private static final String BOX_LIB_LINK_PATH = "//span[contains(text(), 'Box Library')]";
    private static final String BOX_TEMPLATE_PATH = "//span[@class='name-wrapper']/span[contains(text(), 'Autotest template')]";

    @FindBy(xpath = BOX_LIB_LINK_PATH)
    private WebElement boxLibLink;

    @FindBy(xpath = BOX_TEMPLATE_PATH)
    private WebElement boxTemplate;

    public BoxLibraryPage(WebDriver driver) {
        super(driver);
    }


    public ProductPage openLibraryAndSelectBox() {
        boxLibLink.click();
        boxTemplate.click();
        return new ProductPage(driver);
    }
}
