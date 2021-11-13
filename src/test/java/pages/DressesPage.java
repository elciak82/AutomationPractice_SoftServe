package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage extends GenericPage {
    public DressesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".ajax_add_to_cart_button")
    WebElement addDressToCart;

    @FindBy(css = ".continue")
    WebElement continueButton;

    @FindBy(css = "[class = 'btn btn-default button button-medium']")
    WebElement proceedToCheckoutButton;

    @FindBy(css = ".product_img_link")
    WebElement dressOnPage;

    public void addDressToCart(int elementOnPage){
        Actions actions = new Actions(driver);
        actions.moveToElement(dressOnPage).perform();
        addToCart(addDressToCart);
        fluentWaitForElementDisplayed(proceedToCheckoutButton);

    }

    public void continueShopping(){
        continueButton.click();
    }

    public SummaryPage proceedToCheckoutOnDressesPage(){
        proceedToCheckoutButton.click();
        return new SummaryPage(driver);
    }
}
