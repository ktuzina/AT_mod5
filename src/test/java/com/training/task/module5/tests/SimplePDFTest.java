package com.training.task.module5.tests;

import com.training.task.module5.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SimplePDFTest {

    private WebDriver driver;

    @BeforeClass
    public void startBrowser() {
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
        //download of pdf and cf2 files is blocked by W2B-1746
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(orderPage.download1upPDFisVisible(), "1up-PDF button doesn't appear");
        sa.assertTrue(orderPage.download1upCF2isVisible(), "1up-CF2 button doesn't appear");
        sa.assertAll();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
