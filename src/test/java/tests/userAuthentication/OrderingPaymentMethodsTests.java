package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.AlertEnums;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

public class OrderingPaymentMethodsTests {

    private WebDriver driver;
    private Header header;

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();
        header.clickSignInButton().signIn(email, password);
        header.backToHomePage();
    }

    @Test
    public void orderingCompleted_payByBankWireMethod() {
        header.clickDressesTab();

        DressesPage dressesPage = new DressesPage(driver);
        dressesPage.addDressToCart(0);

        dressesPage
                .proceedToCheckoutOnDressesPage()
                .proceedToCheckoutOnSummaryPage()
                .proceedToCheckoutOnAddressesPage()
                .proceedToCheckoutWithTermsOnShippingPage()
                .bankWireMethod()
                .confirmMyOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        Assert.assertTrue(orderConfirmationPage.orderCompleteIsVisible());
        Assert.assertEquals(orderConfirmationPage.getOrderCompleteText(), AlertEnums.AlertMessageEnums.ORDER_IS_COMPLETE.getAlertMessage());
    }

    @Test
    public void orderingCompleted_payByCheckMethod() {
        header.clickDressesTab();

        DressesPage dressesPage = new DressesPage(driver);
        dressesPage.addDressToCart(0);

        dressesPage
                .proceedToCheckoutOnDressesPage()
                .proceedToCheckoutOnSummaryPage()
                .proceedToCheckoutOnAddressesPage()
                .proceedToCheckoutWithTermsOnShippingPage()
                .checkMethod()
                .confirmMyOrder();

        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);

        Assert.assertTrue(orderConfirmationPage.orderCompleteAlertIsVisible());
        Assert.assertEquals(orderConfirmationPage.getOrderCompleteAlertText(), AlertEnums.AlertMessageEnums.ORDER_IS_COMPLETE.getAlertMessage());
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
