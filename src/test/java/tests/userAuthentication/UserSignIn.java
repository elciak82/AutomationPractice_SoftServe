package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.HomePage;

public class UserSignIn {
    private WebDriver driver;
    private HomePage homePage;
    private AuthenticationPage authenticationPage;
    private Configuration configuration;

    @BeforeClass
    public void setUp(){
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        homePage = new HomePage(driver);
    }

    @Test
    public void correctSignIn(){
        homePage.clickSignInButton();

        String email = configuration.getEmail();
        String password = configuration.getPassword();
        authenticationPage.inputEmailAddress(email);
        authenticationPage.inputEmailAddress(password);
        authenticationPage.signInButtonClick();

        String title = authenticationPage.getPageTitle();
        Assert.assertEquals(title, "My account - My Store");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
