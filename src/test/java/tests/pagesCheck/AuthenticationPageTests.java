package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.BaseTest;

public class AuthenticationPageTests extends BaseTest {

    @Test (priority = 2, description = "Verify Authentication Page Title")
    @Description("Test Description: Verify Authentication Page Title")
    @Severity(SeverityLevel.MINOR)
    public void verifyAuthenticationPageTitleTest() {
        header.clickSignInButton();
        String title = header.getPageTitle();

        new PageTitleEnums();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.AUTHENTICATION_PAGE.getPageTitle());
    }
}
