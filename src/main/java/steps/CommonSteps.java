package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import settings.BDDDriver;

import static java.time.Duration.ofMillis;

/**
 * @author segilmez
 */
public class CommonSteps {
    public BDDDriver bddDriver;

    public CommonSteps(BDDDriver bddDriver) {
        this.bddDriver = bddDriver;
    }

    public static void waitForNSeconds(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000L);
        } catch (InterruptedException var3) {
            throw new RuntimeException("Interrupted");
        }
    }

    public void clickByID(String id) {
        bddDriver.currentDriver().findElementById(id).click();
    }

    public void seeByID(String id) {
        bddDriver.currentDriver().findElementById(id);
    }

    public void clickByText(String text) throws Exception {
        seeByText(text).click();
    }

    public void longPressByText(String text) {
        waitForNSeconds(2);
        MobileElement elem = (MobileElement) bddDriver.currentDriver().findElementByXPath("//*[@text='" + text.replace("\"", "") + "']");
        new TouchAction(bddDriver.currentDriver()).longPress(PointOption.point(elem.getCoordinates().onPage()))
                .waitAction(WaitOptions.waitOptions(ofMillis(2000)))
                .release().perform();
    }

    public MobileElement seeByText(String text) throws Exception {
        waitForNSeconds(2);
        text = text.replace("\"","");
        MobileElement element =bddDriver.currentDriver().findElementByXPath("//*[@text=\"" + text + "\"]");
        if (!element.isDisplayed())
            throw new Exception("Text element is unvisible, but we expected it is.");
        return element;
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
        bddDriver.currentDriver().hideKeyboard();
    }

    public void sendKeys(String text) {
        bddDriver.currentDriver().getKeyboard().sendKeys(text);
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
    }

    private void swiper(double rateStartX, double rateEndX, double rateStartY, double rateEndY) {
        int startX, endX, startY, endY;
        Dimension dimension = bddDriver.currentDriver().manage().window().getSize();
        startX = (int) (dimension.getWidth() * rateStartX);
        endX = (int) (dimension.getWidth() * rateEndX);
        startY = (int) (dimension.getHeight() * rateStartY);
        endY = (int) (dimension.getHeight() * rateEndY);
        new TouchAction(bddDriver.currentDriver())
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(ofMillis(1500)))
                .moveTo(PointOption.point(endX, endY))
                .release().perform();
    }
}
