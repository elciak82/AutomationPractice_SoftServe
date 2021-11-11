package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends GenericPage {
    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login")
    WebElement signInButton;

    @FindBy(className = "logout")
    WebElement signOutButton;

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

    public void clickSignOutButton() {
        signOutButton.click();
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
        return new DressesPage(driver);
    }

    public TshirtsPage clickTshirtTab(){
        tshirtTab.click();
        return new TshirtsPage();
    }

    public boolean signOutButtonIsVisible() {
        return signOutButton.isDisplayed();
    }

}