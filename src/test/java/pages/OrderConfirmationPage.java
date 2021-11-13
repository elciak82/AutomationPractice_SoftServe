package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends GenericPage {
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class = 'cheque-indent'] strong")
    WebElement orderComplete;

    @FindBy(css = "[class='alert alert-success']")
    WebElement completeAlert;

    public Boolean orderCompleteIsVisible() {
        return orderComplete.isDisplayed();
    }

    public String getOrderCompleteText() {
        return orderComplete.getText();
    }

    public Boolean orderCompleteAlertIsVisible() {
        return completeAlert.isDisplayed();
    }

    public String getOrderCompleteAlertText() {
        return completeAlert.getText();
    }
}
