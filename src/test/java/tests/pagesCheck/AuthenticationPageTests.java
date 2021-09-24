package tests.pagesCheck;

import helpers.Driver;
import helpers.Configuration;

import helpers.enums.PageTitleEnums;
import pages.Header;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AuthenticationPageTests {
    private WebDriver driver;
    private Header header;

    @BeforeTest
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
        new PageTitleEnums();
    }

    @Test
    public void verifyAuthenticationPageTitleTest() {
        header.clickSignInButton();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.AUTHENTICATION_PAGE.getPageTitle());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
