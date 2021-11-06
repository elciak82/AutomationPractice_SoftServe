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

    private static final String NUMERIC_STRING = "1234567890";
    private static final String ALPHA_STRING = "abcdefghijklmnoprstuvwxyz";
    private static final String suffix = generateSuffix();

    public String randomNumericString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * NUMERIC_STRING.length());
            builder.append(NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String randomAlphaString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_STRING.length());
            builder.append(ALPHA_STRING.charAt(character));
        }
        return builder.toString();
    }

    public static String generateSuffix() {
        return randomAlphaString(6);
    }

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

    public String generateRandomEmail() {
        return "email@" + suffix + ".com";
    }

    public String generateRandomPassword() {
        return "pass" + suffix;
    }

    public String generateRandomUserFirstName() {
        return "FirstName" + suffix;
    }

    public String generateRandomUserLastName() {
        return "LastName" + suffix;
    }

    public String generateRandomCompany() {
        return "Company" + suffix;
    }

    public String generateRandomAddress() {
        return "Address" + suffix;
    }

    public String generateRandomAddressLine2() {
        return "Address2" + suffix;
    }

    public String generateRandomCity() {
        return "City" + suffix;
    }

    public String generateRandomZip() {
        return "12345";
    }

    public String generateRandomPhoneNumber() {
        return "123456789";
    }

    public String generateRandomMobileNumber() {
        return "600600600";
    }

    public String generateRandomAddressAlias() {
        return "Alias" + suffix;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        System.out.println("The page title is " + title);
        return title;

    }

}