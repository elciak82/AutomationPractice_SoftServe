package tests.pagesCheck;

import helpers.Driver;
import helpers.Configuration;
import helpers.enums.PageTitleEnums;
import pages.Header;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DressesPageTests {
    private WebDriver driver;
    private Header header;

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
    }

    @Test
    public void verifyDressesPageTitleTest() {
        header.clickDressesTab();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.DRESSES_PAGE.getPageTitle());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
