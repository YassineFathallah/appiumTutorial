import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class TestGesturesSwipe extends BaseClass {

    public static AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = capabilities();
    }

    @Test
    public void testSwipe(){
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
        WebElement element15 = driver.findElementByXPath(("//*[@content-desc='15']"));
        WebElement element45 = driver.findElementByXPath(("//*[@content-desc='45']"));
        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(element15))
                        .withDuration(Duration.ofSeconds(2)))
                .moveTo(ElementOption.element(element45))
                .release()
                .perform();
    }
}
