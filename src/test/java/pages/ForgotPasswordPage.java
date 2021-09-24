package pages;

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
    WebElement alert;


    public void inputEmailAddress(String email) {
        emailAddress.clear();
        emailAddress.sendKeys(email);
    }

    public void retrievePasswordButtonClick() {
        retrievePasswordButton.click();
    }

    public String getAlertMessage(){
        return alert.getText();
    }

}
