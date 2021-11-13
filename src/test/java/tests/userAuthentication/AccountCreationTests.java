package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
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
        String email = customerFactory.customerRandomEmail();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver); ////// HERE
        authenticationPage.inputEmailAddressCreate(email); ////// HERE
        authenticationPage.createAnAccount()
                .createAnAccountRequiredFields(customerFactory.getCustomerToRegister_required(), StatesEnums.CustomerStateEnums.ALABAMA);

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver); ////// HERE
        String customerFirstNameLastName = createAnAccountPage.getCustomerNameFromAccountPage(); ////// HERE
        Assert.assertEquals(customerFirstNameLastName, customerFactory.getCustomerFirstNameLastName());
    }

    @Test
    public void correctAccountCreation_allFields() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();
        createAnAccountPage.createAnAccountAllFields(customerFactory.getCustomerToRegister_all(), StatesEnums.CustomerStateEnums.ALABAMA, false);

        String customerFirstNameLastName = createAnAccountPage.getCustomerNameFromAccountPage();
        Assert.assertEquals(customerFirstNameLastName, customerFactory.getCustomerFirstNameLastName());
    }

    @Test
    public void incorrectAccountCreation_formPage_missingRequiredField_lastname() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        Customer customer = customerFactory.getCustomerToRegister_required();
        customer.setCustomerLastName("");

        createAnAccountPage.fillAllRequiredFieldsInCreateAnAccountForm(customer, StatesEnums.CustomerStateEnums.ALABAMA);
        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There is 1 error\n" + "lastname is required.");
    }

    @Test
    public void incorrectAccountCreation_formPage_allFieldsEmpty() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There are 8 errors\n" +
                "You must register at least one phone number.\n" +
                "lastname is required.\n" +
                "firstname is required.\n" +
                "passwd is required.\n" +
                "address1 is required.\n" +
                "city is required.\n" +
                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n" +
                "This country requires you to choose a State.");
    }

    @Test
    public void incorrectAccountCreation_authenticationPage_incorrectEmailAddress() {
        header.clickSignInButton();

        authenticationPage.inputEmailAddressCreate("incorrect.email");
        authenticationPage.createAnAccountButtonClick();

        Assert.assertTrue(authenticationPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "Invalid email address.");
    }

    @Test
    public void incorrectAccountCreation_authenticationPage_missingEmailAddress() {
        header.clickSignInButton();

        authenticationPage.createAnAccountButtonClick();

        Assert.assertTrue(authenticationPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "Invalid email address.");
    }

    @Test
    public void incorrectAccountCreation_formPage_invalidMobilePhone() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        Customer customer = customerFactory.getCustomerToRegister_required();
        customer.setMobilePhone("invalidPhone");

        createAnAccountPage.fillAllRequiredFieldsInCreateAnAccountForm(customer, StatesEnums.CustomerStateEnums.ALABAMA);
        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There is 1 error\n" + "phone_mobile is invalid.");
    }

    @Test
    public void incorrectAccountCreation_formPage_invalidZipCode() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        Customer customer = customerFactory.getCustomerToRegister_required();
        customer.setCustomerZip("1234");

        createAnAccountPage.fillAllRequiredFieldsInCreateAnAccountForm(customer, StatesEnums.CustomerStateEnums.ALABAMA);
        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There is 1 error\n" + "The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
    }

    @Test
    public void incorrectAccountCreation_formPage_passwordIsMissing() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        Customer customer = customerFactory.getCustomerToRegister_required();
        customer.setCustomerPassword("");

        createAnAccountPage.fillAllRequiredFieldsInCreateAnAccountForm(customer, StatesEnums.CustomerStateEnums.ALABAMA);
        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There is 1 error\n" + "passwd is required.");
    }

    @Test
    public void incorrectAccountCreation_formPage_passwordIsTooShort() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        Customer customer = customerFactory.getCustomerToRegister_required();
        customer.setCustomerPassword("0o9i");

        createAnAccountPage.fillAllRequiredFieldsInCreateAnAccountForm(customer, StatesEnums.CustomerStateEnums.ALABAMA);
        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There is 1 error\n" + "passwd is invalid.");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
