package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage extends GenericPage {
    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".standard-checkout")
    WebElement proceedToCheckout;

    public void proceedToCheckout(){
        proceedToCheckout.click();
    }
}
