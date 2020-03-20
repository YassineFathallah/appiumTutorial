import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestRun extends BaseClass{

    public static AndroidDriver<AndroidElement> driver; 
    
    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = capabilities();
    }

    @Test
    public void testPreference_happyPath() {
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("test edit text");
        driver.findElementById("android:id/button1").click();
    }
}
