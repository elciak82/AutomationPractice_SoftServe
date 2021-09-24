package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
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
    public void setUp(){
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
        authenticationPage = new AuthenticationPage(driver);
    }

    @Test
    public void correctSignIn(){
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
    public void correctSignOut(){
        header.clickSignInButton();

        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();
        authenticationPage.signIn(email,password);

        header.clickSignOutButton();
        String title = authenticationPage.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.AUTHENTICATION_PAGE.getPageTitle());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
