package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
/**
 * Represents the manual backup consents page.
 */
public class BackupConsentsPage extends Page {

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/checkbox")
    List<WebElement> checkboxesToConsent;

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/next")
    WebElement continueBtn;

    public BackupConsentsPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Method that clicks on all checkboxes in page
     */
    public void consentForAllCheckboxes() {
        for (WebElement checkbox: checkboxesToConsent) {
            clickOnElement(checkbox);
        }
    }

    /**
     * Method that clicks on continue
     */
    public void clickContinue() {
        clickOnElement(continueBtn);
    }
}
