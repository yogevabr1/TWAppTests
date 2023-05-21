package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the backup selection page.
 */
public class BackupPage extends Page {

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Back up manually\")")
    private WebElement backupManually;

    public BackupPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickBackupManually() {
        clickOnElement(backupManually);
    }
}
