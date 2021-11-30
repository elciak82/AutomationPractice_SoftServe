package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ContactsUsPageTests extends BaseTest {

    @Test
    public void verifyContactUsPageTitleTest() {
        header.clickContactUsButton();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.CONTACT_US_PAGE.getPageTitle());
    }
}
