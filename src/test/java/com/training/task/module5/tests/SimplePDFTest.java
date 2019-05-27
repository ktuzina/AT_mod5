package com.training.task.module5.tests;

import com.training.task.module5.pages.LoginPage;
import com.training.task.module5.pages.OrderPage;
import com.training.task.module5.pages.ProductPage;
import com.training.task.module5.utils.Constants;
import com.training.task.module5.utils.PropertyHandler;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SimplePDFTest {

    private WebDriver driver;
    private ProductPage productPage;

    @BeforeMethod(description = "Opens app and goes to Product page")
    public void openProductPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get(PropertyHandler.getTestUrl());
        Thread.sleep(Constants.SLEEP_TIME);
        productPage = new LoginPage(driver).loginUser().openLibraryAndSelectBox();
    }

    @Test(description = "Test orders Simple PDF and checks availability of files")
    public void orderSimplePDF() {

        OrderPage orderPage = productPage.putToCartViaPDFDownload().selectCheckMoneyPaymentMethod().goToOrderDetails();

        //download of pdf and cf2 files is blocked by W2B-1746
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(orderPage.download1upPDFisVisible()).as("1up-PDF button doesn't appear").isTrue();
        sa.assertThat(orderPage.download1upCF2isVisible()).as("1up-CF2 button doesn't appear").isTrue();

    }

    @Test(description = "Test cancels ordering Simple PDF")
    public void cancelOrderSimplePDF() throws InterruptedException {
        boolean productPageIsDisplayed = productPage.cancelPutToCartViaPDFDownload().pageIsDisplayed();
        assertThat(productPageIsDisplayed).isTrue();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}
