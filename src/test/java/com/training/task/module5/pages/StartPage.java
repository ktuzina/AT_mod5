package com.training.task.module5.pages;

import org.openqa.selenium.WebDriver;


public class StartPage extends AbstractPage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() throws InterruptedException {

        String pageUrl="https://w2b-test:nae3qttWgv1axNOzlUaR@www.prinyun-tst.com";
        driver.get(pageUrl);

        Thread.sleep(3000);

    }

}
