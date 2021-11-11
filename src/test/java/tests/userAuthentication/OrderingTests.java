package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAnAccountPage;
import pages.DressesPage;
import pages.Header;

public class OrderingTests {

    private WebDriver driver;
    private Header header;
    private AuthenticationPage authenticationPage;
    private Configuration configuration;
    private CreateAnAccountPage createAnAccountPage;

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
    }

    @Test
    public void signIDuringOrdering() {
        header.clickDressesTab();

        DressesPage dressesPage = new DressesPage(driver);
        dressesPage.addDressToCart(0);

        dressesPage.proceedToCheckout().proceedToCheckout();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);

        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();
        authenticationPage.signIn(email, password);

        Assert.assertTrue(header.signOutButtonIsVisible());
    }
}
