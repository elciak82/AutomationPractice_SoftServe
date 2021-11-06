package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import helpers.enums.PageTitleEnums;
import helpers.models.Form;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.CreateAnAccountPage;
import pages.Header;

public class AccountCreationTests {

    private WebDriver driver;
    private Header header;
    private AuthenticationPage authenticationPage;
    private Configuration configuration;
    private CreateAnAccountPage createAnAccountPage;

    @BeforeMethod
    public void setUp() {
        driver = Driver.initializeWebDriver();
        driver.get(Configuration.getConfiguration().getSiteURL());
        header = new Header(driver);
        authenticationPage = new AuthenticationPage(driver);
        createAnAccountPage = new CreateAnAccountPage(driver);
    }

    @Test
    public void correctAccountCreation_onlyRequiredFields() {
        header.clickSignInButton();

        String email = authenticationPage.generateRandomEmail();
        authenticationPage.inputEmailAddressCreate(email);
        authenticationPage.createAnAccountButtonClick();
//        createAnAccountPage.submitAccountClick();

        String firstName = authenticationPage.generateRandomUserFirstName();
        String lastName = authenticationPage.generateRandomUserLastName();
        String password = authenticationPage.generateRandomPassword();
        String address = authenticationPage.generateRandomAddress();
        String city = authenticationPage.generateRandomCity();
        String zip = authenticationPage.generateRandomZip();
        String mobilePhone = authenticationPage.generateRandomMobileNumber();
        String addressAlias = authenticationPage.generateRandomAddressAlias();

        Form userForm = Form.builder()
                .customerFirstName(firstName)
                .customerLastName(lastName)
                .customerPassword(password)
                .customerAddress(address)
                .customerCity(city)
                .customerZip(zip)
                .customerMobilePhone(mobilePhone)
                .customerAddressAlias(addressAlias)
                .build();

//        System.out.println(userForm.builder().getCustomerFirstName());
        createAnAccountPage.createAnAccountRequired(userForm);

        String title = authenticationPage.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.MY_ACCOUNT_PAGE.getPageTitle());

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
