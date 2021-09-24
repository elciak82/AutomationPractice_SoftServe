package tests.pagesCheck;

import helpers.Driver;
import helpers.Configuration;

import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AuthenticationPageTests {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeTest
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyAuthenticationPageTitleTest() {
        homePage.clickSignInButton();
        String title = homePage.getPageTitle();
        Assert.assertEquals(title, "Login - My Store");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
