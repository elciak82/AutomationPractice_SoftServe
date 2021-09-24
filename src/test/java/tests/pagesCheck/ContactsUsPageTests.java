package tests.pagesCheck;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.PageTitleEnums;
import pages.Header;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsUsPageTests {
    private WebDriver driver;
    private Header header;

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
    }

    @Test
    public void verifyContactUsPageTitleTest() {
        header.clickContactUsButton();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.CONTACT_US_PAGE.getPageTitle());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
