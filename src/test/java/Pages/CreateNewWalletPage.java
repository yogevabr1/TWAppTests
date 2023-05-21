package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the first page of the app - the creation of a wallet (or sign in)
 */
public class CreateNewWalletPage extends Page {

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/new_account_action")
    WebElement createNewWalletBtn;
    public CreateNewWalletPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void clickCreateNewWallet() {
        clickOnElement(createNewWalletBtn);
    }

}
