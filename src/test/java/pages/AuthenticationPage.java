package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends GenericPage {
    public AuthenticationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement emailAddress;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    @FindBy(css = "[class = 'alert alert-danger'] li")
    WebElement alert;

    @FindBy(css = "[title='Recover your forgotten password']")
    WebElement forgotPasswordLink;

    @FindBy(id = "email_create")
    WebElement emailCreate;

    @FindBy (id = "SubmitCreate")
    WebElement createAnAccountButton;

    @FindBy(css = "[id = 'submitAccount']")
    WebElement submitAccount;

    @FindBy(css = "[id = 'create_account_error'] li")
    WebElement createAnAccountError;


    public void inputEmailAddress(String email) {
        emailAddress.clear();
        emailAddress.sendKeys(email);
    }

    public void inputPassword(String passwd) {
        password.clear();
        password.sendKeys(passwd);
    }

    public void signInButtonClick() {
        signInButton.click();
    }

    public void signIn(String email, String password) {
        inputEmailAddress(email);
        inputPassword(password);
        signInButtonClick();
    }

    public String getAlertMessage() {
        return alert.getText();
    }

    public ForgotPasswordPage forgotPasswordLinkClick() {
        fluentWaitForElementDisplayed(forgotPasswordLink);
        forgotPasswordLink.click();
        return new ForgotPasswordPage(driver); ////// HERE
    }

    public void inputEmailAddressCreate(String newEmail) {
        emailCreate.clear();
        emailCreate.sendKeys(newEmail);
    }

    public CreateAnAccountPage createAnAccount(){
        createAnAccountButton.click();
        fluentWaitForElementDisplayed(submitAccount);
        return new CreateAnAccountPage(driver);
    }

    public void createAnAccountButtonClick(){
        createAnAccountButton.click();
    }

    public Boolean alertIsVisible() {
        fluentWaitForElementDisplayed(createAnAccountError);
        return createAnAccountError.isDisplayed();
    }

    public String getAlertText() {
        return createAnAccountError.getText();
    }

}
