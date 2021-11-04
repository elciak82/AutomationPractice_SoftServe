package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;

public class GenericPage {
    WebDriver driver;

    private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnoprstuvwxyz1234567890";

    GenericPage(WebDriver driver) {
        this.driver = driver;
//        documentReady();
    }

    public void fluentWaitForElementDisplayed(WebElement elementToBeDisplayed) {
        new FluentWait<>(elementToBeDisplayed)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(WebElement::isDisplayed);
    }

    public void documentReady() {
        boolean readyStateComplete = false;
        while (!readyStateComplete) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.scrollTo(0, document.body.offsetHeight)");
            readyStateComplete = executor.executeScript("return document.readyState").equals("complete");
        }
    }

    public String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public String generateSuffix() {
        return randomAlphaNumeric(6);
    }

    public String generateRandomEmail() {
        return "email@" + generateSuffix() + ".com";
    }

    public String generateRandomPassword() {
        return "pass_" + generateSuffix();
    }

    public String generateRandomUserFirstName() {
        return "FirstName_" + generateSuffix();
    }

    public String generateRandomUserLastName() {
        return "LastName_" + generateSuffix();
    }

    public String generateRandomACompany() {
        return "Company_" + generateSuffix();
    }

    public String generateRandomAddress() {
        return "Address_" + generateSuffix();
    }

    public String generateRandomAddressLine2() {
        return "Address2_" + generateSuffix();
    }

    public String generateRandomCountry() {
        return "Country" + generateSuffix();
    }

    public String generateRandomZipCode() {
        return "12345";
    }

    public String generateRandomZPhoneNumber() {
        return "123456789";
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        System.out.println("The page title is " + title);
        return title;

    }

}