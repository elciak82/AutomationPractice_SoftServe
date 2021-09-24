package tests.pagesCheck;

import helpers.Configuration;
import helpers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;

public class HomePageTests {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp(){
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyHomePageTitleTest(){
        String title = homePage.getPageTitle();
        Assert.assertEquals(title, "My Store");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
