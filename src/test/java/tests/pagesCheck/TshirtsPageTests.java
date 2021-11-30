package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TshirtsPageTests extends BaseTest {

    @Test
    public void verifyTshirtPageTitleTest() {
        header.clickTshirtTab();
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.TSHIRT_PAGE.getPageTitle());
    }
}
