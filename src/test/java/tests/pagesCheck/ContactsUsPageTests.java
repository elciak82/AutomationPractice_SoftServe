package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ContactsUsPageTests extends BaseTest {

    @Test (priority = 2, description = "Verify Contact Us Page Title")
    @Description("Test Description: Verify Contact Us Page Title")
    @Severity(SeverityLevel.MINOR)
    public void verifyContactUsPageTitleTest() {
        header.clickContactUsButton();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.CONTACT_US_PAGE.getPageTitle());
    }
}
