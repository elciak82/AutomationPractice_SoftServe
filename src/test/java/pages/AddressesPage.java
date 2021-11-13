package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage extends GenericPage {
    public AddressesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='processAddress']")
    WebElement proceedToCheckout;



    public ShippingPage proceedToCheckoutOnAddressesPage(){
        proceedToCheckout.click();
        return new ShippingPage(driver);
    }

}
