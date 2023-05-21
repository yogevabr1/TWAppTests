package Specs;

import Pages.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppTests extends BaseSpec {

    @Test
    public void createWalletTest() throws InterruptedException {
        final String CODE_PHRASE = "111111";

        CreateNewWalletPage createNewWalletPage = new CreateNewWalletPage(driver);
        createNewWalletPage.clickCreateNewWallet();

        UserAgreementPage agreementPage = new UserAgreementPage(driver);
        agreementPage.acceptTerms();
        agreementPage.clickContinue();

        CodePhrasePage codePhrasePage = new CodePhrasePage(driver);
        codePhrasePage.selectCode(CODE_PHRASE);
        codePhrasePage = new CodePhrasePage(driver);
        codePhrasePage.selectCode(CODE_PHRASE);

        BackupPage backupPage = new BackupPage(driver);
        backupPage.clickBackupManually();

        BackupConsentsPage backupConsentsPage = new BackupConsentsPage(driver);
        backupConsentsPage.consentForAllCheckboxes();
        backupConsentsPage.clickContinue();

        RecoveryPhrasePage recoveryPhrasePage = new RecoveryPhrasePage(driver);
        List<String> wordsList = recoveryPhrasePage.getCorrectPhraseWordsAsString();
        recoveryPhrasePage.clickContinue();

        ConfirmRecoveryPhrasePage confirmRecoveryPhrasePage = new ConfirmRecoveryPhrasePage(driver);
        confirmRecoveryPhrasePage.clickOnPhraseWordsInCorrectOrder(wordsList);
        confirmRecoveryPhrasePage.assertThatMessageIsSuccess();
        confirmRecoveryPhrasePage.clickDone();
    }
}
