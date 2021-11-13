package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends GenericPage {
    public PaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bankwire")
    WebElement bankWire;

    @FindBy(className = "cheque")
    WebElement check;

    public OrderSummaryPage bankWireMethod(){
        bankWire.click();
        return new OrderSummaryPage(driver);
    }

    public OrderSummaryPage checkMethod(){
        check.click();
        return new OrderSummaryPage(driver);
    }


}
