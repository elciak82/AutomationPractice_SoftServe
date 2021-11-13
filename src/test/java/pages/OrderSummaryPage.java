package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends GenericPage {
    public OrderSummaryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class='cart_navigation clearfix'] [type='submit']")
    WebElement confirmMyOrder;

    public OrderConfirmationPage confirmMyOrder() {
        confirmMyOrder.click();
        return new OrderConfirmationPage(driver);
    }


}
