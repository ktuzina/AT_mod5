package com.training.task.module5.pages;

import com.training.task.module5.utils.Constants;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class StartPage extends AbstractPage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() throws InterruptedException {

        //String pageUrl = "https://w2b-test:nae3qttWgv1axNOzlUaR@www.prinyun-tst.com";

        String pageUrl = "";

        try (InputStream input = new FileInputStream("src/test/resources/test.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            pageUrl = prop.getProperty("testUrl");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        driver.get(pageUrl);

        Thread.sleep(Constants.SLEEP_TIME);

        return new LoginPage(driver);
    }

}
