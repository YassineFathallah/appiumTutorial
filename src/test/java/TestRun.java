import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestRun {

    public static AndroidDriver<AndroidElement> driver; 
    
    @BeforeTest
    public void setup() throws MalformedURLException {
            File appDir = new File("src/main/resources");
            File app = new File(appDir, "original.apk");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "yassine_emulator");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void test01() {
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        driver.findElementByClassName("android.widget.EditText").sendKeys("test edit text");
        driver.findElementById("android:id/button1").click();
    }
}
