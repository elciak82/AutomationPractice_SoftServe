package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.BaseTest;

public class HomePageTests extends BaseTest {

    @Test(priority = 2, description = "Verify Home Page Title")
    @Description("Test Description: Verify Home Page Title")
    @Severity(SeverityLevel.MINOR)
    public void verifyHomePageTitleTest(){
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.HOME_PAGE.getPageTitle());
    }
}
