package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class DressesPageTests extends BaseTest {

    @Test
    public void verifyDressesPageTitleTest() {
        header.clickDressesTab();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.DRESSES_PAGE.getPageTitle());
    }
}
