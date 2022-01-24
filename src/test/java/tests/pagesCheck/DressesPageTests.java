package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class DressesPageTests extends BaseTest {

    @Test(priority = 2, description = "Verify Dresses Page Title")
    @Description("Test Description: Verify Dresses Page Title")
    @Severity(SeverityLevel.MINOR)
    public void verifyDressesPageTitleTest() {
        header.clickDressesTab();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.DRESSES_PAGE.getPageTitle());
    }
}
