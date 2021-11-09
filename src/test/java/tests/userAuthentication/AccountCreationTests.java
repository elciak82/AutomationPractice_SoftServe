package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.PageTitleEnums;
import helpers.enums.StatesEnums;
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
        String email = customerFactory.customerRandomEmail();

        authenticationPage.inputEmailAddressCreate(email); ////// HERE
        authenticationPage.createAnAccountButtonClick();
        createAnAccountPage.createAnAccountRequiredFields(customerFactory.getCustomerToRegister_required(), StatesEnums.CustomerStateEnums.ALABAMA);

        String customerFirstNameLastName = createAnAccountPage.getCustomerNameFromAccountPage();
        Assert.assertEquals(customerFirstNameLastName, customerFactory.getCustomerFirstNameLastName());

    }

    @Test
    public void correctAccountCreation_allFields() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        authenticationPage.inputEmailAddressCreate(email); ////// HERE
        authenticationPage.createAnAccountButtonClick();

        createAnAccountPage.createAnAccountAllFields(customerFactory.getCustomerToRegister_all(), StatesEnums.CustomerStateEnums.ALABAMA, false);

        String customerFirstNameLastName = createAnAccountPage.getCustomerNameFromAccountPage();
        Assert.assertEquals(customerFirstNameLastName, customerFactory.getCustomerFirstNameLastName());

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
