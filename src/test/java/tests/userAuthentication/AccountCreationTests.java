package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.AlertEnums;
import helpers.enums.PageTitleEnums;
import helpers.models.Form;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.ForgotPasswordPage;
import pages.Header;

public class AccountCreationTests {

    private WebDriver driver;
    private Header header;
    private AuthenticationPage authenticationPage;
    private Configuration configuration;
    private ForgotPasswordPage forgotPasswordPage;

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
        authenticationPage = new AuthenticationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Test
    public void correctAccountCreation_onlyRequiredFields() {
        header.clickSignInButton();

        String email = authenticationPage.generateRandomEmail();
        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccountButtonClick();

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
