package com.training.task.module5.tests;

import com.training.task.module5.pages.LoginPage;
import com.training.task.module5.pages.OrderPage;
import com.training.task.module5.pages.ProductPage;
import com.training.task.module5.utils.Constants;
import com.training.task.module5.utils.PropertyHandler;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class SimplePDFTest {

    private WebDriver driver;
    private ProductPage productPage;

    public WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    private void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", Constants.DOWNLOAD_PATH);
        prefs.put("plugins.always_open_pdf_externally", true);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        options.addArguments("start-maximized");
        options.setCapability("platformName", Platform.WINDOWS);

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }


    @BeforeMethod(description = "Opens app and goes to Product page")
    public void openProductPage() throws InterruptedException {
        //launch without hub and nodes
        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
        //driver = new ChromeDriver(options);
        //driver = getDriver();
        getDriver().get(PropertyHandler.getTestUrl());
        Thread.sleep(Constants.SLEEP_TIME);
        productPage = new LoginPage(getDriver()).loginUser().openLibraryAndSelectBox();
    }

    @Test(description = "Test orders Simple PDF and checks availability of files")
    public void orderSimplePDF() {
        OrderPage orderPage = productPage.putToCartViaPDFDownload().selectCheckMoneyPaymentMethod().goToOrderDetails();

        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(orderPage.isNotEmpty1upPDF()).as("1up-PDF file is empty").isTrue();
        sa.assertThat(orderPage.isNotEmpty1upCF2()).as("1up-CF2 file is empty").isTrue();
    }

    @Test(description = "Test cancels ordering Simple PDF")
    public void cancelOrderSimplePDF() throws InterruptedException {
        boolean productPageIsDisplayed = productPage.cancelPutToCartViaPDFDownload().pageIsDisplayed();
        assertThat(productPageIsDisplayed).isTrue();
    }

    @AfterMethod
    public void closeBrowser() {
        getDriver().quit();
        driver = null;
    }

}
