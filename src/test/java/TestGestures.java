import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class TestGestures extends BaseClass {

    public static AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = capabilities();
    }

    @Test
    public void testPressAndHold() {
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        TouchAction touchAction = new TouchAction(driver);
        String expandableListLocatorString = "//android.widget.TextView[@text='Expandable Lists']";
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(driver.findElementByXPath(expandableListLocatorString)))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
        WebElement peopleNamesElement = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        touchAction
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(peopleNamesElement))
                        .withDuration(Duration.ofSeconds(2)))
                .release()
                .perform();

        WebElement sampleActionElement = driver.findElementById("android:id/title");
        assert sampleActionElement.isDisplayed();
    }
}
