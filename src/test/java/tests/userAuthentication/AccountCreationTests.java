package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.PageTitleEnums;
import helpers.enums.StatesEnums;
import helpers.models.Customer;
import helpers.providers.CustomerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAnAccountPage;
import pages.Header;

public class AccountCreationTests {

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
        authenticationPage = new AuthenticationPage(driver); ////// HERE
        createAnAccountPage = new CreateAnAccountPage(driver); ////// HERE

    }

    @Test
    public void correctAccountCreation_onlyRequiredFields() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.generateRandomEmail();

        authenticationPage.inputEmailAddressCreate(email); ////// HERE
        authenticationPage.createAnAccountButtonClick();
        createAnAccountPage.createAnAccountRequired(customerFactory.getCustomerToRegister_Required(), StatesEnums.CustomerStateEnums.ALABAMA);

        String title = authenticationPage.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.MY_ACCOUNT_PAGE.getPageTitle());

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
