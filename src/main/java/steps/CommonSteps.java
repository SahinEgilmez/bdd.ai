package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import settings.AIDriver;

import java.net.MalformedURLException;

import static java.time.Duration.ofMillis;

/**
 * @author segilmez
 */
public class CommonSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonSteps.class);
    public AIDriver aiDriver;
    public AndroidDriver androidDriver;

    public CommonSteps() throws MalformedURLException {
        aiDriver = AIDriver.getInstance();
        androidDriver = aiDriver.androidDriver;
    }

    @When("^(?:I will )?wait (\\d+) seconds?$")
    public static void waitForNSeconds(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000L);
        } catch (InterruptedException var3) {
            throw new RuntimeException("Interrupted");
        }
    }

    @When("^(?:I will )?click ((?:\"[^\"]*\")+)$")
    public void clickByText(String text) {
        androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']").click();
    }

    @When("^(?:I will )?see ((?:\"[^\"]*\")+)$")
    public void seeByText(String text) {
        androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']");
    }

    @When("^(?:I will not )?see ((?:\"[^\"]*\")+)$")
    public void notSeeByText(String text) {
        try {
            MobileElement element = (MobileElement) androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']");
        } catch (Exception e) {
            System.out.println("SUCCESS: I didn't see:" + text);
        }
    }

    @When("^(?:I will )?hide keyboard$")
    public void hideKeyboard() {
        androidDriver.hideKeyboard();
    }

    @When("^(?:I will )?enter (\\w+(?: \\w+)*)$")
    public void sendKeys(String text) {
        androidDriver.getKeyboard().sendKeys(text);
    }

    @When("^(?:I will )?swipe (up|down|left|right)$")
    public void swipe(String direction) throws Exception {
        direction = direction.toLowerCase();
        if (direction.equals("down")) {
            swiper(0.5, 0.5, 0.2, 0.8);
        } else if (direction.equals("up")) {
            swiper(0.5, 0.5, 0.8, 0.2);
        } else if (direction.equals("right")) {
            swiper(0.2, 0.8, 0.5, 0.5);
        } else if (direction.equals("left")) {
            swiper(0.8, 0.2, 0.5, 0.5);
        } else {
            throw new Exception("Wrong direction!");
        }
        LOGGER.info("SCROLL:" + direction);
    }

    private void swiper(double rateStartX, double rateEndX, double rateStartY, double rateEndY) {
        int startX, endX, startY, endY;
        Dimension dimension = androidDriver.manage().window().getSize();
        startX = (int) (dimension.getWidth() * rateStartX);
        endX = (int) (dimension.getWidth() * rateEndX);
        startY = (int) (dimension.getHeight() * rateStartY);
        endY = (int) (dimension.getHeight() * rateEndY);
        new TouchAction(androidDriver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(ofMillis(1500)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }

    @Before
    public void setUp() throws MalformedURLException {
        aiDriver.setUp();
    }

    @After
    public void tearDown() {
        aiDriver.tearDown();
    }
}
