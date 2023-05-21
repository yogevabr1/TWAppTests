package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Basic page class that all pages inherit from.
 * The main purpose is to have one source of 'AppiumDriver' and a custom 'click' method.
 */
public class Page {
    protected AppiumDriver driver;

    public Page(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException | ElementNotInteractableException e) {
            System.out.println("ERROR: Element is not clickable or not exists");
            assert false;
        }
    }
}
