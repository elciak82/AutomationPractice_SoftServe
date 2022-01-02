package tests.userAuthentication;

import helpers.Configuration;
import helpers.enums.AlertEnums;
import helpers.enums.PageTitleEnums;
import helpers.providers.CustomerFactory;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AuthenticationPage;
import pages.ForgotPasswordPage;
import tests.BaseTest;
//import utils.listeners.TestListener;

//@Listeners({TestListener.class})
@Epic("Regression Tests")
@Feature("User Sign In Tests")
public class UserSignInTests extends BaseTest {

    @Test(priority = 4, description = "Correct Sign In")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Correct Sign In")
    @Story("Correct Sign In")
    public void correctSignIn() {
        header.clickSignInButton();

        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.inputEmailAddress(email);
        authenticationPage.inputPassword(password);
        authenticationPage.signInButtonClick();

        String title = authenticationPage.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.MY_ACCOUNT_PAGE.getPageTitle());
    }

//    @Test
//    public void correctSignOut() {
//        header.clickSignInButton();
//
//        String email = Configuration.getConfiguration().getEmail();
//        String password = Configuration.getConfiguration().getPassword();
//        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(email, password);
//
//        header.clickSignOutButton();
//        String title = authenticationPage.getPageTitle();
//        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.AUTHENTICATION_PAGE.getPageTitle());
//    }
//
//    @Test
//    public void incorrectSignIn_incorrectEmailAddress() {
//        header.clickSignInButton();
//
//        CustomerFactory customerFactory = new CustomerFactory();
//        String incorrectEmail = "invalid";
//        String password = customerFactory.customerRandomPassword();
//        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(incorrectEmail, password);
//
//        String error = authenticationPage.getAlertMessage();
//        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.INVALID_EMAIL_ADDRESS_ERROR.getAlertMessage());
//    }
//
//    @Test
//    public void incorrectSignIn_incorrectPassword() {
//        header.clickSignInButton();
//
//        CustomerFactory customerFactory = new CustomerFactory();
//        String email = customerFactory.customerRandomEmail();
//        String incorrectPassword = "pass";
//        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(email, incorrectPassword);
//
//        String error = authenticationPage.getAlertMessage();
//        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.INVALID_PASSWORD_ERROR.getAlertMessage());
//    }
//
//    @Test
//    public void incorrectSignIn_incorrectEmailAddressAndPassword_authenticationFailed() {
//        header.clickSignInButton();
//
//        CustomerFactory customerFactory = new CustomerFactory();
//        String incorrectEmail = customerFactory.customerRandomEmail();
//        String incorrectPassword = customerFactory.customerRandomPassword();
//        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(incorrectEmail, incorrectPassword);
//
//        String error = authenticationPage.getAlertMessage();
//        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.AUTHENTICATION_FAILED_ERROR.getAlertMessage());
//    }
//
//    @Test
//    public void incorrectSignIn_missingEmailAddress() {
//        header.clickSignInButton();
//
//        CustomerFactory customerFactory = new CustomerFactory();
//        String email = "";
//        String password = customerFactory.customerRandomPassword();
//        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(email, password);
//
//        String error = authenticationPage.getAlertMessage();
//        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.EMAIL_ADDRESS_REQUIRED_ERROR.getAlertMessage());
//    }
//
//    @Test
//    public void incorrectSignIn_missingEmailAddressAndPassword() {
//        header.clickSignInButton();
//
//        String email = "";
//        String password = "";
//        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(email, password);
//
//        String error = authenticationPage.getAlertMessage();
//        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.EMAIL_ADDRESS_REQUIRED_ERROR.getAlertMessage());
//    }
//
//    @Test
//    public void incorrectSignIn_missingPassword() {
//        header.clickSignInButton();
//
//        CustomerFactory customerFactory = new CustomerFactory();
//        String email = customerFactory.customerRandomEmail();
//        String password = "";
//        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.signIn(email, password);
//
//        String error = authenticationPage.getAlertMessage();
//        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.PASSWORD_REQUIRED_ERROR.getAlertMessage());
//    }
//
//    @Test
//    public void forgotPassword_correctEmailAddress() {
//        header.clickSignInButton();
//
//        String email = Configuration.getConfiguration().getEmail();
//        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.forgotPasswordLinkClick().inputEmailAddress(email);
//
//        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
//        forgotPasswordPage.retrievePasswordButtonClick();
//
//        String confirmationFromPage = forgotPasswordPage.getConfirmationMessage();
//        String confirmation = AlertEnums.AlertMessageEnums.FORGOT_PASSWORD_CONFIRMATION.getAlertMessage();
//        String confirmationEmail = confirmation + email;
//        Assert.assertEquals(confirmationFromPage, confirmationEmail);
//    }
//
//    @Test
//    public void forgotPassword_incorrectEmailAddress() {
//        header.clickSignInButton();
//
//        CustomerFactory customerFactory = new CustomerFactory();
//        String incorrectEmail = customerFactory.customerRandomEmail();
//        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
//        authenticationPage.forgotPasswordLinkClick();
//
//        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
//        forgotPasswordPage.inputEmailAddress(incorrectEmail);
//        forgotPasswordPage.retrievePasswordButtonClick();
//
//        String error = forgotPasswordPage.getErrorMessage();
//        Assert.assertEquals(error, AlertEnums.AlertMessageEnums.NO_ACCOUNT_REGISTER_ERROR.getAlertMessage());
//    }
}
