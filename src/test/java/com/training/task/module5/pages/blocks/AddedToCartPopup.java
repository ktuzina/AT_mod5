package com.training.task.module5.pages.blocks;

import com.training.task.module5.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//aside[contains(@class, 'simple_pdf')]")
public class AddedToCartPopup extends HtmlElement {

    @FindBy(className = "proceed-checkout")
    private Button proceedCheckoutBtn;

    public void proceedToCheckout(WebDriver driver) {
        BrowserUtils.click(proceedCheckoutBtn, driver);
    }

}
