package pages;

import helpers.enums.StatesEnums;
import helpers.models.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage extends GenericPage {
    public CreateAnAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "uniform-id_gender1")
    WebElement genderMrRadio;

    @FindBy(id = "uniform-id_gender2")
    WebElement genderMrsRadio;

    @FindBy(id = "customer_firstname")
    WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    WebElement customerLastName;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "days")
    WebElement days;

    @FindBy(id = "months")
    WebElement months;

    @FindBy(id = "years")
    WebElement years;

    @FindBy(id = "uniform-newsletter")
    WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    WebElement specialOffersCheckbox;

    @FindBy(id = "firstname")
    WebElement firstname;

    @FindBy(id = "lastname")
    WebElement lastname;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement addressLine1;

    @FindBy(id = "address2")
    WebElement addressLine2;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "uniform-id_state")
    WebElement getState;

    @FindBy(id = "id_state")
    WebElement state;

    @FindBy(id = "postcode")
    WebElement postcode;

    @FindBy(id = "id_country")
    WebElement country;

    @FindBy(id = "other")
    WebElement additionalInformation;

    @FindBy(id = "phone")
    WebElement homePhone;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "alias")
    WebElement addressAlias;

    @FindBy(css = "[id = 'submitAccount']")
    WebElement submitAccount;

    public void selectFromDropdown (WebElement webElement, StatesEnums.CustomerStateEnums customerState) {
        Select dropdown = new Select(webElement);
        dropdown.selectByValue(String.valueOf(customerState.getState()));
    }

    public void createAnAccountRequired(Customer customer, StatesEnums.CustomerStateEnums stateEnum) {
        customerLastName.isDisplayed();
        customerFirstName.sendKeys(customer.getCustomerFirstName());
        customerLastName.sendKeys(customer.getCustomerLastName());
        password.sendKeys(customer.getCustomerPassword());
        addressLine1.sendKeys(customer.getCustomerAddress());
        city.sendKeys(customer.getCustomerCity());
        selectFromDropdown(state, stateEnum);
        postcode.sendKeys(customer.getCustomerZip());
        mobilePhone.sendKeys(customer.getCustomerMobilePhonePhone());
        addressAlias.sendKeys(customer.getCustomerAddressAlias());
        submitAccount.click();
    }

    public void submitAccountClick(){
        submitAccount.click();
}













}
