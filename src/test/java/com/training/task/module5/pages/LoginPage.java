package com.training.task.module5.pages;

import com.training.task.module5.utils.Constants;
import com.training.task.module5.utils.PropertyHandler;
import com.training.task.module5.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='web2box-header']//div[@class='auth-not-logged-in']//a")
    private WebElement loginLink;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "pass")
    private WebElement passwordField;

    @FindBy(id = "send2")
    private WebElement signInBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public BoxLibraryPage loginUser() {
        loginLink.click();
        emailField.sendKeys(PropertyHandler.getCredentials().getUser());
        passwordField.sendKeys(PropertyHandler.getCredentials().getPassword());
        signInBtn.click();

        WaitUtils.sleepSomeSecs();

        return new BoxLibraryPage(driver);
    }
}
