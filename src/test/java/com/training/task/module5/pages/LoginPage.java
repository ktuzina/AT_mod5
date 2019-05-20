package com.training.task.module5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {

    private static String LOGIN_LINK_PATH = "//div[@id='web2box-header']//div[@class='auth-not-logged-in']//a";
    private static String EMAIL_FIELD_ID = "email";
    private static String PASSWORD_FIELD_ID = "pass";
    private static String SIGN_IN_BUTTON_ID = "send2";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        WebElement loginLink = driver.findElement(By.xpath(LOGIN_LINK_PATH));
        loginLink.click();
    }

    public void loginUser() throws InterruptedException {
        WebElement emailField = driver.findElement(By.id(EMAIL_FIELD_ID));
        WebElement passwordField = driver.findElement(By.id(PASSWORD_FIELD_ID));
        WebElement signInBtn = driver.findElement(By.id(SIGN_IN_BUTTON_ID));
        emailField.sendKeys("katsiaryna.tuzina@gersis-software.com");
        passwordField.sendKeys("genTSY59YsEA4ZN");
        signInBtn.click();

        Thread.sleep(3000);
    }
}
