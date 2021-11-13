package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPage extends GenericPage {
    public SummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".standard-checkout")
    WebElement proceedToCheckout;

    public AddressesPage proceedToCheckoutOnSummaryPage(){
        proceedToCheckout.click();
        return new AddressesPage(driver);
    }


}
