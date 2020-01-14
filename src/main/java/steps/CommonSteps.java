package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import settings.BDDDriver;

import java.net.MalformedURLException;
import java.util.logging.Logger;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;

/**
 * @author segilmez
 */
public class CommonSteps {
    private Logger LOGGER = Logger.getLogger(CommonSteps.class.getName());
    public BDDDriver BDDDriver;

    public CommonSteps(BDDDriver bddDriver) throws MalformedURLException {
        BDDDriver = bddDriver;
    }

    public void launchDevice(String alias) throws Exception {
        BDDDriver.launchDevice(alias);
    }

    public static void waitForNSeconds(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000L);
        } catch (InterruptedException var3) {
            throw new RuntimeException("Interrupted");
        }
    }

    public void clickByText(String text) {
        BDDDriver.androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']").click();
    }

    public void longPressByText(String text) {
        MobileElement elem = (MobileElement) BDDDriver.androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']");
        new TouchAction(BDDDriver.androidDriver).longPress(PointOption.point(elem.getCoordinates().onPage()))
                .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                .release().perform();
    }

    public void seeByText(String text) throws Exception {
        if (!BDDDriver.androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']").isDisplayed())
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
        BDDDriver.androidDriver.hideKeyboard();
    }

    public void sendKeys(String text) {
        BDDDriver.androidDriver.getKeyboard().sendKeys(text);
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
        Dimension dimension = BDDDriver.androidDriver.manage().window().getSize();
        startX = (int) (dimension.getWidth() * rateStartX);
        endX = (int) (dimension.getWidth() * rateEndX);
        startY = (int) (dimension.getHeight() * rateStartY);
        endY = (int) (dimension.getHeight() * rateEndY);
        new TouchAction(BDDDriver.androidDriver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(ofMillis(1500)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }
}
