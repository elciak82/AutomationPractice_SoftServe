package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class WomenPageTests extends BaseTest {

    @Test
    public void verifyWomenPageTitleTest() {
        header.clickWomenTab();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.WOMEN_PAGE.getPageTitle());
    }
}
