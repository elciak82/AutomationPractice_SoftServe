package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class WomenPageTests extends BaseTest {

    @Test (priority = 2, description = "Verify Women Page Title")
    @Description ("Test Description: Verify Women Page Title")
    @Severity(SeverityLevel.MINOR)
    public void verifyWomenPageTitleTest() {
        header.clickWomenTab();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.WOMEN_PAGE.getPageTitle());
    }
}
