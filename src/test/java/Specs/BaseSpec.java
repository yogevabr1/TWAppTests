package Specs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BaseSpec {
    private static final String DEVICE_NAME = "test"; // My own Android Device Simulator name.
    private static final String APP_PATH = "/Users/yogev/Downloads/v7.21.1_release.apk"; // My app path

    public static AppiumDriver driver;

    /**
     * Method that executed before tests started. Main purpose to set the capabilities for the test.
     * @throws MalformedURLException
     */
    @BeforeAll
    public static void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.APP, APP_PATH);
        capabilities.setCapability("appPackage", "com.wallet.crypto.trustapp");
        capabilities.setCapability("appWaitActivity", "*");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    /**
     * Method that executed after tests finished. Main purpose to quit the driver.
     */
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
