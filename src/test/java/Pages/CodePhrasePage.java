package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodePhrasePage extends Page {

    private Map<String,WebElement> digitsMap;
    // Select all numbers buttons in page
    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"[0-9]\")")
    private List<WebElement> digitElements;

    public CodePhrasePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        digitsMap = new HashMap<>();
        for (WebElement element: digitElements) { // Assign every number with its element to an HashMap for easy lookup
            digitsMap.put(element.getText(), element);
        }
    }

    /**
     * Validate that the inserted code (by the developer) is a number and also its length.
     * Then, clicks on the relevant digits number.
     * @param code The desired code.
     */
    public void selectCode(String code) {
        try {
            Integer.valueOf(code);
            if (code.length() == 6) {
                for (int i=0; i<code.length(); i++) {
                    clickOnDigit(code.charAt(i));
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Code is not valid number");
            assert false;
            throw e;
        }
    }

    private void clickOnDigit(char digit) {
        clickOnElement(digitsMap.get(String.valueOf(digit)));
    }
}
