package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the recovery phrase page with its 12 words
 */
public class RecoveryPhrasePage extends Page {

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/value") // The 12 words list.
    List<WebElement> correctPhraseWords;

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/action_verify")
    WebElement continueBtn;

    public RecoveryPhrasePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickContinue() {
        clickOnElement(continueBtn);
    }

    /**
     * Method to get the String list of the 12 words in the correct order.
     * @return List of strings.
     */
    public List<String> getCorrectPhraseWordsAsString() {
        List<String> wordsAsString = new ArrayList<>();
        for (WebElement word: correctPhraseWords) {
            wordsAsString.add(word.getText());
        }
        return wordsAsString;
    }


}
