package pages;

import helpers.enums.StatesEnums;
import helpers.models.Customer;
import io.qameta.allure.Step;
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

    @FindBy(id = "id_gender1")
    WebElement genderMrRadio;

    @FindBy(id = "id_gender2")
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

    @FindBy(className = "account")
    WebElement customerName;

    @FindBy(css = "[class = 'alert alert-danger']")
    WebElement alert;

    public void selectStateFromDropdown(WebElement webElement, StatesEnums.CustomerStateEnums customerState) {
        Select dropdown = new Select(webElement);
        dropdown.selectByValue(String.valueOf(customerState.getState()));
    }

    public void selectRandomDateFromDropdown() {
        Select dateDropdown = new Select(days);
        dateDropdown.selectByValue("1");

        Select monthDropdown = new Select(months);
        monthDropdown.selectByValue("1");

        Select yearDropdown = new Select(years);
        yearDropdown.selectByValue("1991");
    }
    @Step("Create an account Step with required fields: {method}")
    public void fillAllRequiredFieldsInCreateAnAccountForm(Customer customer, StatesEnums.CustomerStateEnums stateEnum) {
        customerLastName.isDisplayed();
        customerFirstName.sendKeys(customer.getCustomerFirstName());
        customerLastName.sendKeys(customer.getCustomerLastName());
        password.sendKeys(customer.getCustomerPassword());
        addressLine1.sendKeys(customer.getCustomerAddress());
        city.sendKeys(customer.getCustomerCity());
        selectStateFromDropdown(state, stateEnum);
        postcode.sendKeys(customer.getCustomerZip());
        mobilePhone.sendKeys(customer.getCustomerMobilePhonePhone());
        addressAlias.sendKeys(customer.getCustomerAddressAlias());
    }

    @Step("Create an account Step with required fields: {method}")
    public void createAnAccountRequiredFields(Customer customer, StatesEnums.CustomerStateEnums stateEnum) {
        fillAllRequiredFieldsInCreateAnAccountForm(customer, stateEnum);
        submitAccount.click();
    }


    public void fillAllFieldsInCreateAnAccountForm(Customer customer, StatesEnums.CustomerStateEnums stateEnum, boolean gender) {
        customerLastName.isDisplayed();

        if (!gender) {
            genderMrsRadio.click();
        } else
            genderMrRadio.click();

        customerFirstName.sendKeys(customer.getCustomerFirstName());
        customerLastName.sendKeys(customer.getCustomerLastName());
        password.sendKeys(customer.getCustomerPassword());
        selectRandomDateFromDropdown();
        signUpForNewsletterCheckbox();
        receiveSpecialOffersCheckbox();
        addressLine1.sendKeys(customer.getCustomerAddress());
        addressLine2.sendKeys(customer.getCustomerAddress2());
        city.sendKeys(customer.getCustomerCity());
        selectStateFromDropdown(state, stateEnum);
        postcode.sendKeys(customer.getCustomerZip());
        additionalInformation.sendKeys(customer.getCustomerAdditionalInfo());
        company.sendKeys(customer.getCustomerCompany());
        homePhone.sendKeys(customer.getCustomerHomePhone());
        mobilePhone.sendKeys(customer.getCustomerMobilePhonePhone());
        addressAlias.sendKeys(customer.getCustomerAddressAlias());
    }

    @Step("Create an account Step with all fields: {method}")
    public void createAnAccountAllFields(Customer customer, StatesEnums.CustomerStateEnums stateEnum, boolean gender) {
        fillAllFieldsInCreateAnAccountForm(customer, stateEnum, gender);
        submitAccount.click();
    }

    public void signUpForNewsletterCheckbox() {
        newsletterCheckbox.click();
    }

    public void receiveSpecialOffersCheckbox() {
        specialOffersCheckbox.click();
    }

    @Step("Submit account Step...")
    public void submitAccountClick() {
        submitAccount.click();
    }

    public String getCustomerNameFromAccountPage() {
        return customerName.getText();
    }

    public Boolean alertIsVisible() {
        return alert.isDisplayed();
    }

    public String getAlertText() {
        return alert.getText();
    }

}
