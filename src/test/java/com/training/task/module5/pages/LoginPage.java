package com.training.task.module5.pages;

import com.training.task.module5.utils.BrowserUtils;
import com.training.task.module5.utils.Log;
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
        BrowserUtils.click(loginLink, driver);
        Log.info("Enter email address");
        emailField.sendKeys(PropertyHandler.getCredentials().getUser());
        Log.info("Enter password");
        passwordField.sendKeys(PropertyHandler.getCredentials().getPassword());
        BrowserUtils.click(signInBtn, driver);

        WaitUtils.sleepSomeSecs();

        return new BoxLibraryPage(driver);
    }
}
