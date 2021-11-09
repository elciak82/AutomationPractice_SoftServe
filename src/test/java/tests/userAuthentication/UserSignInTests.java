package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.AlertEnums;
import helpers.enums.PageTitleEnums;
import helpers.providers.CustomerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AuthenticationPage;
import pages.ForgotPasswordPage;
import pages.Header;

public class UserSignInTests {
    private WebDriver driver;
    private Header header;
    private AuthenticationPage authenticationPage;
    private Configuration configuration;
    private ForgotPasswordPage forgotPasswordPage;
    private CustomerFactory customerFactory;

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
        authenticationPage = new AuthenticationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Test
    public void correctSignIn() {
        header.clickSignInButton();

        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();

        authenticationPage.inputEmailAddress(email);
        authenticationPage.inputPassword(password);
        authenticationPage.signInButtonClick();

        String title = authenticationPage.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.MY_ACCOUNT_PAGE.getPageTitle());
    }

    @Test
    public void correctSignOut() {
        header.clickSignInButton();

        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();
        authenticationPage.signIn(email, password);

        header.clickSignOutButton();
        String title = authenticationPage.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.AUTHENTICATION_PAGE.getPageTitle());
    }

    @Test
    public void incorrectSignIn_incorrectEmailAddress() {
        header.clickSignInButton();

        String incorrectEmail = "invalid";
        String password = customerFactory.customerRandomPassword();
        authenticationPage.signIn(incorrectEmail, password);

        String error = authenticationPage.getAlertMessage();
        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.INVALID_EMAIL_ADDRESS_ERROR.getAlertMessage());
    }

    @Test
    public void incorrectSignIn_incorrectPassword() {
        header.clickSignInButton();

        String email = customerFactory.customerRandomEmail();
        String incorrectPassword = "pass";
        authenticationPage.signIn(email, incorrectPassword);

        String error = authenticationPage.getAlertMessage();
        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.INVALID_PASSWORD_ERROR.getAlertMessage());
    }

    @Test
    public void incorrectSignIn_incorrectEmailAddressAndPassword_authenticationFailed() {
        header.clickSignInButton();

        String incorrectEmail = customerFactory.customerRandomEmail();
        String incorrectPassword = customerFactory.customerRandomPassword();
        authenticationPage.signIn(incorrectEmail, incorrectPassword);

        String error = authenticationPage.getAlertMessage();
        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.AUTHENTICATION_FAILED_ERROR.getAlertMessage());
    }

    @Test
    public void incorrectSignIn_missingEmailAddress() {
        header.clickSignInButton();

        String email = "";
        String password = customerFactory.customerRandomPassword();
        authenticationPage.signIn(email, password);

        String error = authenticationPage.getAlertMessage();
        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.EMAIL_ADDRESS_REQUIRED_ERROR.getAlertMessage());
    }

    @Test
    public void incorrectSignIn_missingEmailAddressAndPassword() {
        header.clickSignInButton();

        String email = "";
        String password = "";
        authenticationPage.signIn(email, password);

        String error = authenticationPage.getAlertMessage();
        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.EMAIL_ADDRESS_REQUIRED_ERROR.getAlertMessage());
    }

    @Test
    public void incorrectSignIn_MissingPassword() {
        header.clickSignInButton();

        String email = customerFactory.customerRandomEmail();
        String password = "";
        authenticationPage.signIn(email, password);

        String error = authenticationPage.getAlertMessage();
        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.PASSWORD_REQUIRED_ERROR.getAlertMessage());
    }

    @Test
    public void forgotPassword_correctEmailAddress() {
        header.clickSignInButton();

        String email = Configuration.getConfiguration().getEmail();
        authenticationPage.forgotPasswordLinkClick().inputEmailAddress(email); ////// HERE
        forgotPasswordPage.retrievePasswordButtonClick();

        String confirmationFromPage = forgotPasswordPage.getConfirmationMessage();
        String confirmation = AlertEnums.AlertMessageEnums.FORGOT_PASSWORD_CONFIRMATION.getAlertMessage();
        String confirmationEmail = confirmation + email;
        Assert.assertEquals(confirmationFromPage, confirmationEmail);
    }

    @Test
    public void forgotPassword_incorrectEmailAddress() {
        header.clickSignInButton();

        String incorrectEmail = customerFactory.customerRandomEmail();
        authenticationPage.forgotPasswordLinkClick();
        forgotPasswordPage.inputEmailAddress(incorrectEmail);
        forgotPasswordPage.retrievePasswordButtonClick();

        String error = forgotPasswordPage.getErrorMessage();
        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.NO_ACCOUNT_REGISTER_ERROR.getAlertMessage());
    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
