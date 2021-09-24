package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends GenericPage {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login")
    WebElement signInButton;

    @FindBy(id = "contact-link")
    WebElement contactUsButton;

    @FindBy(css = "[id='block_top_menu'] a[title='Women']")
    WebElement womenTab;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[2]/a")
    WebElement dressesTab;


    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
    WebElement tshirtTab;

    public AuthenticationPage clickSignInButton() {
        signInButton.click();
        return new AuthenticationPage(driver);
    }

    public ContactUsPage clickContactUsButton(){
        contactUsButton.click();
        return new ContactUsPage();
    }

    public WomenPage clickWomenTab(){
        womenTab.click();
        return new WomenPage();
    }

    public DressesPage clickDressesTab(){
        dressesTab.click();
        return new DressesPage();
    }

    public TshirtsPage clickTshirtTab(){
        tshirtTab.click();
        return new TshirtsPage();
    }

}