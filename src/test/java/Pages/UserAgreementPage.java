package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the user agreement page.
 */
public class UserAgreementPage extends Page {

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/acceptCheckBox")
    WebElement acceptCheckbox;

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/next")
    WebElement continueBtn;

    public UserAgreementPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void acceptTerms() {
        clickOnElement(acceptCheckbox);
    }

    public void clickContinue() {
        clickOnElement(continueBtn);
    }
}
