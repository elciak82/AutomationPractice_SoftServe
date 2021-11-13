package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.AlertEnums;
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

    @Test
    public void ordering_signIDuringOrdering() {
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

    @Test
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
