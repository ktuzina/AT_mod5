package com.training.task.module5.tests;

import com.training.task.module5.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SimplePDFTest {

    private WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void orderSimplePDF() throws InterruptedException {
        StartPage startPage = new StartPage(driver);
        startPage.openPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginUser();

        BoxLibraryPage boxLibraryPage = new BoxLibraryPage(driver);
        boxLibraryPage.openBoxLibrary();
        boxLibraryPage.selectBox();
        ProductPage productPage = new ProductPage(driver);
        productPage.createClone();
        productPage.putToCartViaPDFDownload();
        ReviewPaymentsPage reviewPaymentsPage = new ReviewPaymentsPage(driver);
        reviewPaymentsPage.selectCheckMoneyPaymentMethod();

        PurchaseSuccessPage purchaseSuccessPage = new PurchaseSuccessPage(driver);
        purchaseSuccessPage.goToOrderDetails();

        OrderPage orderPage = new OrderPage(driver);
        Assert.assertTrue(orderPage.pageIsDisplayed(), "Order page is not opened");

        //download of pdf and cf2 files is blocked by W2B-1746
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
