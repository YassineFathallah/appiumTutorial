import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestUiAutomator extends BaseClass{
    public static AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = capabilities();
    }

    @Test
    public void testViewUsingUiAutomator() {
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        int clickableListSize = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
        assert (clickableListSize > 1);
    }
}
