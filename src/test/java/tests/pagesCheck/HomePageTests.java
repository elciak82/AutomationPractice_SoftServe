package tests.pagesCheck;

import helpers.enums.PageTitleEnums;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.BaseTest;

public class HomePageTests extends BaseTest {

    @Test
    public void verifyHomePageTitleTest(){
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.HOME_PAGE.getPageTitle());
    }
}
