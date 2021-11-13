package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage extends GenericPage {
    public ShippingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".standard-checkout")
    WebElement proceedToCheckout;

    @FindBy(className = "fancybox-error")
    WebElement error;

    @FindBy(css = "[type='checkbox']")
    WebElement termsOfServiceCheckbox;

    public PaymentPage proceedToCheckoutOnShippingPage() {
        proceedToCheckout.click();
        return new PaymentPage(driver);
    }

    public PaymentPage proceedToCheckoutWithTermsOnShippingPage() {
        termsOfServiceCheckbox.click();
        proceedToCheckout.click();
        return new PaymentPage(driver);
    }

    public Boolean errorIsVisible() {
        return error.isDisplayed();
    }

    public String getErrorText() {
        return error.getText();
    }
}
