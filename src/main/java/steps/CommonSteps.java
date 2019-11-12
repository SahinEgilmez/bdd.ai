package steps;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import settings.AIDriver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.logging.Logger;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;

/**
 * @author segilmez
 */
public class CommonSteps {
    private Logger LOGGER = Logger.getLogger(CommonSteps.class.getName());
    public AIDriver aiDriver;

    public CommonSteps() throws MalformedURLException {
        aiDriver = AIDriver.getInstance();
    }

    public static void waitForNSeconds(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000L);
        } catch (InterruptedException var3) {
            throw new RuntimeException("Interrupted");
        }
    }

    public void clickByText(String text) {
        aiDriver.androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']").click();
    }

    public void longPressByText(String text) {
        MobileElement elem = (MobileElement) aiDriver.androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']");
        new TouchAction(aiDriver.androidDriver).longPress(PointOption.point(elem.getCoordinates().onPage()))
                .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                .release().perform();
    }

    public void seeByText(String text) throws Exception {
        if (!aiDriver.androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']").isDisplayed())
            throw new Exception("Text element is unvisible, but we expected it is.");
    }

    public void notSeeByText(String text) throws Exception {
        try {
            seeByText(text);
        } catch (Exception e) {
            return;
        }
        throw new Exception("Text element is visible, but we expected it not to.\n");
    }

    public void hideKeyboard() {
        aiDriver.androidDriver.hideKeyboard();
    }

    public void sendKeys(String text) {
        aiDriver.androidDriver.getKeyboard().sendKeys(text);
    }

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
        Dimension dimension = aiDriver.androidDriver.manage().window().getSize();
        startX = (int) (dimension.getWidth() * rateStartX);
        endX = (int) (dimension.getWidth() * rateEndX);
        startY = (int) (dimension.getHeight() * rateStartY);
        endY = (int) (dimension.getHeight() * rateEndY);
        new TouchAction(aiDriver.androidDriver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(ofMillis(1500)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }
}
