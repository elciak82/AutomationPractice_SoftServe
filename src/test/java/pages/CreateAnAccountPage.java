package pages;

import helpers.models.Form;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void createAnAccountRequired(Form form) {
        customerLastName.isDisplayed();
        customerFirstName.sendKeys(form.getCustomerFirstName());
        customerLastName.sendKeys(form.getCustomerLastName());
//        password.sendKeys();
        submitAccount.click();
    }

    public void submitAccountClick(){
        submitAccount.click();
}













}
