package tests.userAuthentication;

import helpers.Configuration;
import helpers.Driver;
import helpers.models.Form;
import org.openqa.selenium.WebDriver;
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

        String FirstName = authenticationPage.generateRandomUserFirstName();
        String LastName = authenticationPage.generateRandomUserLastName();

        Form userForm = Form.builder()
                .customerFirstName("FirstName")
                .customerLastName("LastName")
                .customerLastName("Pass")
                .build();

//        System.out.println(userForm.builder().getCustomerFirstName());
        createAnAccountPage.createAnAccountRequired(userForm);

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
