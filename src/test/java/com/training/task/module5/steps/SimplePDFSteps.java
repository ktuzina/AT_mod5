package com.training.task.module5.steps;

import com.training.task.module5.factory.WebDriverFactory;
import com.training.task.module5.pages.LoginPage;
import com.training.task.module5.pages.OrderPage;
import com.training.task.module5.pages.ProductPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SimplePDFSteps {

    private WebDriver driver;
    private ProductPage productPage;
    private OrderPage orderPage;


    @Given("^User (?:navigates to|opens) library and selects \"[^\\\"]*\" box$")
    public void selectBox() {
        driver = WebDriverFactory.getDriver();
        productPage = new LoginPage(driver).loginUser().openLibraryAndSelectBox();
    }

    @Given("^User orders Simple PDF$")
    public void orderSimplePDF() {
        orderPage = productPage.putToCartViaPDFDownload().selectCheckMoneyPaymentMethod().goToOrderDetails();
    }

    @When("^User download 1up-PDF$")
    public void download1upPDF() {
        orderPage.download1upPDF();
    }

    @And("^User download 1up-CF2$")
    public void download1upCF2() {
        orderPage.download1upCF2();
    }

    @Then("^Downloaded files are not empty$")
    public void checkFileNotEmpty() {
        SoftAssertions sa = new SoftAssertions();
        sa.assertThat(orderPage.isNotEmpty1upPDF()).as("1up-PDF file is empty").isTrue();
        sa.assertThat(orderPage.isNotEmpty1upCF2()).as("1up-CF2 file is empty").isTrue();
    }

    @Given("^User opens Simple PDF popup$")
    public void openSimplePDFPopup() {
        productPage.createClone();
        productPage.openSimplePDFPopup();
    }

    @When("^User clicks Cancel$")
    public void cancelSimplePDF() {
        productPage.cancelSimplePDF();
    }
    
    @Then("^Popup is closed$")
    public void popupIsClosed() {
        boolean productPageIsDisplayed = productPage.pageIsDisplayed();
        assertThat(productPageIsDisplayed).isTrue();
    }


}
