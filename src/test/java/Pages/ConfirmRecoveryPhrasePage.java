package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the confirm recovery phrase page
 */
public class ConfirmRecoveryPhrasePage extends Page {

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/value")
    ArrayList<WebElement> wordsInPhrase;

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/message")
    WebElement message;

    @AndroidFindBy(id = "com.wallet.crypto.trustapp:id/action_done")
    WebElement continueBtn;


    public ConfirmRecoveryPhrasePage(AppiumDriver driver) throws InterruptedException {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        int seconds = 0;
        while (wordsInPhrase.size() != 12 && seconds != 3) { // There might be a load issue due to performance issues. With a limit of 3 seconds.
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
            Thread.sleep(1000);
            seconds++;
        }
        if (wordsInPhrase.size() != 12) {
            System.out.println("Not enough words to continue tests in confirm recovery phrase page");
            assert false;
        }
    }

    public void clickOnPhraseWordsInCorrectOrder(List<String> expectedOrder) {
        // I tried to use HashMap which is the best solution, but, I saw while testing the code that there are sometimes duplication of words in the phrase, and HashMap is not helpful in this case.
        for (String wordToSearch : expectedOrder) {
            for (WebElement wordInPage: wordsInPhrase) {
                if (wordInPage.getText().equals(wordToSearch)) {
                    clickOnElement(wordInPage);
                    wordsInPhrase.remove(wordInPage); // In order to manage duplicate words, I delete from the list any word I click on.
                    break;
                }
            }
        }
    }

    public void clickDone() {
        continueBtn.click();
    }

    public void assertThatMessageIsSuccess() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        assert message.getText().equals("Well done! "); // There is a space at the end of the String on your app.
    }

}
