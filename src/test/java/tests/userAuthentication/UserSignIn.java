package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.ErrorMessageEnums;
import helpers.enums.PageTitleEnums;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.Header;

public class UserSignIn {
    private WebDriver driver;
    private Header header;
    private AuthenticationPage authenticationPage;
    private Configuration configuration;

    @BeforeClass
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
        authenticationPage = new AuthenticationPage(driver);
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
    public void incorrectSignIn_IncorrectEmailAddress() {
        header.clickSignInButton();

        String invalidEmail = "invalid";
        String password = header.generateRandomPassword();
        authenticationPage.signIn(invalidEmail, password);

        String error = authenticationPage.getMessageError();
        Assert.assertEquals(error, ErrorMessageEnums.ErrorEnums.INVALID_EMAIL_ADDRESS.getErrorMessage());
    }

    @Test
    public void incorrectSignIn_IncorrectPassword() {
        header.clickSignInButton();

        String email = header.generateRandomEmail();
        String invalidPassword = "pass";
        authenticationPage.signIn(email, invalidPassword);

        String error = authenticationPage.getMessageError();
        Assert.assertEquals(error, ErrorMessageEnums.ErrorEnums.INVALID_PASSWORD.getErrorMessage());
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
