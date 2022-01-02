package tests.userAuthentication;

import helpers.enums.StatesEnums;
import helpers.models.Customer;
import helpers.providers.CustomerFactory;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAnAccountPage;
import tests.BaseTest;

@Epic("Regression Tests")
@Feature("Create an account Tests")
public class AccountCreationTests extends BaseTest {

    @Test(priority = 4, description = "Correct account creation - only required fields")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Correct account creation - only required fields")
    @Story("Account creation")
    public void correctAccountCreation_onlyRequiredFields() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount()
                .createAnAccountRequiredFields(customerFactory.getCustomerToRegister_required(), StatesEnums.CustomerStateEnums.ALABAMA);

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        String customerFirstNameLastName = createAnAccountPage.getCustomerNameFromAccountPage();
        Assert.assertEquals(customerFirstNameLastName, customerFactory.getCustomerFirstNameLastName());
    }

    @Test(priority = 2, description = "Correct account creation - all fields")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Correct account creation - all fields")
    @Story("Account creation")
    public void correctAccountCreation_allFields() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.createAnAccountAllFields(customerFactory.getCustomerToRegister_all(), StatesEnums.CustomerStateEnums.ALABAMA, false);

        String customerFirstNameLastName = createAnAccountPage.getCustomerNameFromAccountPage();
        Assert.assertEquals(customerFirstNameLastName, customerFactory.getCustomerFirstNameLastName());
    }

    @Test(priority = 2, description = "Incorrect account creation - Form page: missing last name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Incorrect account creation - form page: missing last name")
    @Story("Account creation")
    public void incorrectAccountCreation_formPage_missingRequiredField_lastname() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        Customer customer = customerFactory.getCustomerToRegister_required();
        customer.setCustomerLastName("");

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.fillAllRequiredFieldsInCreateAnAccountForm(customer, StatesEnums.CustomerStateEnums.ALABAMA);
        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There is 1 error\n" + "lastname is required.");
    }

    @Test(priority = 2, description = "Incorrect account creation - Form page: all fields empty")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Incorrect account creation - Form page: all fields empty")
    @Story("Account creation")
    public void incorrectAccountCreation_formPage_allFieldsEmpty() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
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

    @Test(priority = 2, description = "Incorrect account creation - Authentication page: incorrect email address")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Incorrect account creation - Authentication page: incorrect email address")
    @Story("Account creation")
    public void incorrectAccountCreation_authenticationPage_incorrectEmailAddress() {
        header.clickSignInButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailAddressCreate("incorrect.email");
        authenticationPage.createAnAccountButtonClick();

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        Assert.assertTrue(authenticationPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "Invalid email address.");
    }

    @Test(priority = 1, description = "Incorrect account creation - Authentication page: missing email address")
    @Severity(SeverityLevel.MINOR)
    @Description("Test Description: Incorrect account creation - Authentication page: missing email address")
    @Story("Account creation")
    public void incorrectAccountCreation_authenticationPage_missingEmailAddress() {
        header.clickSignInButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.createAnAccountButtonClick();

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        Assert.assertTrue(authenticationPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "Invalid email address.");
    }

    @Test(priority = 2, description = "Incorrect account creation - Form page: invalid mobile phone")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Incorrect account creation - Form page: invalid mobile phone")
    @Story("Account creation")
    public void incorrectAccountCreation_formPage_invalidMobilePhone() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        Customer customer = customerFactory.getCustomerToRegister_required();
        customer.setMobilePhone("invalidPhone");

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.fillAllRequiredFieldsInCreateAnAccountForm(customer, StatesEnums.CustomerStateEnums.ALABAMA);
        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There is 1 error\n" + "phone_mobile is invalid.");
    }

    @Test(priority = 2, description = "Incorrect account creation - Form page: invalid zip code")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Incorrect account creation - Form page: invalid zip code")
    @Story("Account creation")
    public void incorrectAccountCreation_formPage_invalidZipCode() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        Customer customer = customerFactory.getCustomerToRegister_required();
        customer.setCustomerZip("1234");

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.fillAllRequiredFieldsInCreateAnAccountForm(customer, StatesEnums.CustomerStateEnums.ALABAMA);
        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There is 1 error\n" + "The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
    }

    @Test(priority = 2, description = "Incorrect account creation - Form page: password is missing")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Incorrect account creation - Form page: password is missing")
    @Story("Account creation")
    public void incorrectAccountCreation_formPage_passwordIsMissing() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        Customer customer = customerFactory.getCustomerToRegister_required();
        customer.setCustomerPassword("");

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.fillAllRequiredFieldsInCreateAnAccountForm(customer, StatesEnums.CustomerStateEnums.ALABAMA);
        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There is 1 error\n" + "passwd is required.");
    }

    @Test(priority = 1, description = "Incorrect account creation - Form page: password is too short")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test Description: Incorrect account creation - Form page: password is too short")
    @Story("Account creation")
    public void incorrectAccountCreation_formPage_passwordIsTooShort() {
        header.clickSignInButton();

        CustomerFactory customerFactory = new CustomerFactory();
        String email = customerFactory.customerRandomEmail();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccount();

        Customer customer = customerFactory.getCustomerToRegister_required();
        customer.setCustomerPassword("0o9i");

        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.fillAllRequiredFieldsInCreateAnAccountForm(customer, StatesEnums.CustomerStateEnums.ALABAMA);
        createAnAccountPage.submitAccountClick();

        Assert.assertTrue(createAnAccountPage.alertIsVisible());
        Assert.assertEquals(createAnAccountPage.getAlertText(), "There is 1 error\n" + "passwd is invalid.");
    }

}
