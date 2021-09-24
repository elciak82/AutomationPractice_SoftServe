package tests.pagesCheck;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.PageTitleEnums;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Header;

public class HomePageTests {
    private WebDriver driver;
    private Header header;

    @BeforeClass
    public void setUp(){
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
    }

    @Test
    public void verifyHomePageTitleTest(){
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.HOME_PAGE.getPageTitle());
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
