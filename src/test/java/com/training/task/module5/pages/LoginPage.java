package com.training.task.module5.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private static final String LOGIN_LINK_PATH = "//div[@id='web2box-header']//div[@class='auth-not-logged-in']//a";
    private static final String EMAIL_FIELD_ID = "email";
    private static final String PASSWORD_FIELD_ID = "pass";
    private static final String SIGN_IN_BUTTON_ID = "send2";

    @FindBy(xpath = LOGIN_LINK_PATH)
    private WebElement loginLink;

    @FindBy(id = EMAIL_FIELD_ID)
    private WebElement emailField;

    @FindBy(id = PASSWORD_FIELD_ID)
    private WebElement passwordField;

    @FindBy(id = SIGN_IN_BUTTON_ID)
    private WebElement signInBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public BoxLibraryPage loginUser() throws InterruptedException {
        loginLink.click();
        emailField.sendKeys("katsiaryna.tuzina@gersis-software.com");
        passwordField.sendKeys("genTSY59YsEA4ZN");
        signInBtn.click();

        Thread.sleep(3000);

        return new BoxLibraryPage(driver);
    }
}
