package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends GenericPage {
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement emailAddress;

    @FindBy(css = "[class = 'submit'] [type = 'submit']")
    WebElement retrievePasswordButton;

    @FindBy (css = "[class = 'alert alert-success']")
    WebElement conformation;

    @FindBy (css = "[class = 'alert alert-danger'] li")
    WebElement error;


    @Step("Input email address Step...")
    public void inputEmailAddress(String email) {
        emailAddress.clear();
        emailAddress.sendKeys(email);
    }

    @Step("Retrieve password button click Step...")
    public void retrievePasswordButtonClick() {
        retrievePasswordButton.click();
    }

    public String getConfirmationMessage(){
        return conformation.getText();
    }

    public String getErrorMessage(){
        return error.getText();
    }

}
