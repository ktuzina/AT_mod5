package com.training.task.module5.tests;

import com.training.task.module5.pages.LoginPage;
import com.training.task.module5.pages.OrderPage;
import com.training.task.module5.pages.ProductPage;
import com.training.task.module5.utils.FilesHandler;
import com.training.task.module5.utils.PropertyHandler;
import com.training.task.module5.utils.SetupDriver;
import com.training.task.module5.utils.WaitUtils;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SimplePDFTest {

    private WebDriver driver;
    private ProductPage productPage;

    @BeforeMethod(description = "Opens app and goes to Product page")
    public void openProductPage() {
        FilesHandler.cleanDownloadDirectory();
        SetupDriver setupDriver = new SetupDriver();
        driver = setupDriver.getDriver();
        driver.get(PropertyHandler.getTestUrl());
        WaitUtils.sleepSomeSecs();
        productPage = new LoginPage(driver).loginUser().openLibraryAndSelectBox();
    }

    @Test(description = "Test orders Simple PDF and checks availability of files")
    public void orderSimplePDF() {
        OrderPage orderPage = productPage.putToCartViaPDFDownload().selectCheckMoneyPaymentMethod().goToOrderDetails();

        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(orderPage.isNotEmpty1upPDF()).as("1up-PDF file is empty").isTrue();
        sa.assertThat(orderPage.isNotEmpty1upCF2()).as("1up-CF2 file is empty").isTrue();
    }

    @Test(description = "Test cancels ordering Simple PDF")
    public void cancelOrderSimplePDF() {
        boolean productPageIsDisplayed = productPage.cancelPutToCartViaPDFDownload().pageIsDisplayed();
        assertThat(productPageIsDisplayed).isTrue();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }

}
