package com.training.task.module5.pages.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//aside[contains(@class, 'simple-input-line-modal')]")
public class ClonePopup extends HtmlElement {

    @FindBy(xpath = ".//span[contains(text(), 'Create Clone')]")
    private Button createCloneBtn;

    public void confirmCloneCreation(WebDriver driver) {
        createCloneBtn.click();
    }
}
