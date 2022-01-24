package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TshirtsPageTests extends BaseTest {

    @Test (priority = 2, description = "Verify T-shirt Page Title")
    @Description("Test Description: Verify T-shirt Page Title")
    @Severity(SeverityLevel.MINOR)
    public void verifyTshirtPageTitleTest() {
        header.clickTshirtTab();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.TSHIRT_PAGE.getPageTitle());
    }
}
