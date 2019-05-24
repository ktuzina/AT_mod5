package com.training.task.module5.tests;

import com.training.task.module5.pages.OrderPage;
import com.training.task.module5.pages.ProductPage;
import com.training.task.module5.pages.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SimplePDFTest {

    private WebDriver driver;
    private ProductPage productPage;

    @BeforeClass
    public void openProductPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        productPage = new StartPage(driver).openPage().loginUser()
                .openLibraryAndSelectBox();
    }

    @Test
    public void orderSimplePDF() {

        OrderPage orderPage = productPage.putToCartViaPDFDownload().selectCheckMoneyPaymentMethod().goToOrderDetails();

        //download of pdf and cf2 files is blocked by W2B-1746
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(orderPage.download1upPDFisVisible(), "1up-PDF button doesn't appear");
        sa.assertTrue(orderPage.download1upCF2isVisible(), "1up-CF2 button doesn't appear");
        sa.assertAll();
    }

    @Test
    public void cancelOrderSimplePDF() throws InterruptedException {
        boolean productPageIsDisplayed = productPage.cancelPutToCartViaPDFDownload().pageIsDisplayed();
        Assert.assertTrue(productPageIsDisplayed);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

}
