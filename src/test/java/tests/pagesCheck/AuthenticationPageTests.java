package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.BaseTest;

public class AuthenticationPageTests extends BaseTest {

    @Test
    public void verifyAuthenticationPageTitleTest() {
        header.clickSignInButton();
        String title = header.getPageTitle();

        new PageTitleEnums();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.AUTHENTICATION_PAGE.getPageTitle());
    }
}
