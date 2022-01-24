package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.AlertEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class OrderingTests {

    private WebDriver driver;
    private Header header;

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
    }

    @Test(priority = 1, description = "Ordering - Sign in during ordering")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Ordering - Sign in during ordering")
    @Story("Ordering")
    public void ordering_signInDuringOrdering() {
        header.clickDressesTab();

        DressesPage dressesPage = new DressesPage(driver);
        dressesPage.addDressToCart(0);

        dressesPage
                .proceedToCheckoutOnDressesPage()
                .proceedToCheckoutOnSummaryPage();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);

        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();
        authenticationPage.signIn(email, password);

        Assert.assertTrue(header.signOutButtonIsVisible());
    }

    @Test(priority = 1, description = "Ordering incomplete - Terms of service missing")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Ordering incomplete - Terms of service missing")
    @Story("Ordering")
    public void orderingIncomplete_termsOfServiceMissing() {

        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();
        header.clickSignInButton().signIn(email, password);
        header.clickDressesTab();

        DressesPage dressesPage = new DressesPage(driver);
        dressesPage.addDressToCart(0);

        dressesPage
                .proceedToCheckoutOnDressesPage()
                .proceedToCheckoutOnSummaryPage()
                .proceedToCheckoutOnAddressesPage()
                .proceedToCheckoutOnShippingPage();

        ShippingPage shippingPage = new ShippingPage(driver);
        Assert.assertTrue(shippingPage.errorIsVisible());
        Assert.assertEquals(shippingPage.getErrorText(), AlertEnums.AlertMessageEnums.TERMS_OF_SERVICE_AGREE_ERROR.getAlertMessage());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
