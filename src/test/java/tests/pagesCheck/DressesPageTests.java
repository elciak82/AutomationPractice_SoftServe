package tests.pagesCheck;

import helpers.Driver;
import helpers.Configuration;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DressesPageTests {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyDressesPageTitleTest() {
        homePage.clickDressesTab();
        String title = homePage.getPageTitle();
        Assert.assertEquals(title, "Dresses - My Store");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
