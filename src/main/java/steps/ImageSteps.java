package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import settings.AIDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.Base64;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author segilmez: Sahin Egilmez
 */
public class ImageSteps {
    private Logger LOGGER = Logger.getLogger(ImageSteps.class.getName());
    public AIDriver aiDriver;

    public ImageSteps() throws MalformedURLException {
        aiDriver = AIDriver.getInstance();
    }

    public void clickByImage(String elementKey) throws Exception {
        MobileElement element = seeByImage(elementKey);
        element.click();
    }

    public void clickByImageWithThreshold(String elementKey, double threshold) throws Exception {
        double oldThreshold = (double) aiDriver.androidDriver.getSettings().get("imageMatchThreshold");
        aiDriver.androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, threshold);
        clickByImage(elementKey);
        aiDriver.androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, oldThreshold);
    }

    public MobileElement seeByImage(String elementKey) throws Exception {
        String path = "ai-config/images/" + elementKey.replace(" ", "_") + ".png";
        MobileElement element = (MobileElement) aiDriver.androidDriver.findElementByImage(getReferenceImageB64(path));
        if (element.isDisplayed())
            return element;
        else
            throw new Exception("NOT FOUND IMAGE");
    }

    public void seeByImageWithThreshold(String elementKey, double threshold) throws Exception {
        double oldThreshold = (double) aiDriver.androidDriver.getSettings().get("imageMatchThreshold");
        aiDriver.androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, threshold);
        seeByImage(elementKey);
        aiDriver.androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, oldThreshold);
    }

    public void notSeeByImage(String elementKey) throws Exception {
        try {
            seeByImage(elementKey);
        } catch (Exception e) {
            return;
        }
        throw new Exception("The element is visible, but we expected it not to.");
    }

    public void notSeeByImageWithThreshold(String elementKey, double threshold) throws Exception {
        double oldThreshold = (double) aiDriver.androidDriver.getSettings().get("imageMatchThreshold");
        aiDriver.androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, threshold);
        notSeeByImage(elementKey);
        aiDriver.androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, oldThreshold);
    }

    public String getReferenceImageB64(String path) throws IOException {
        File refImgFile = new File(path);
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    public File getSSByElement(String elementKey, String by, String key) throws IOException {
        MobileElement element = null;
        key = key.replace("\"", "");
        if (by.equals("id"))
            element = (MobileElement) aiDriver.androidDriver.findElement(By.id(key));
        else if (by.equals("xpath")) {
            element = (MobileElement) aiDriver.androidDriver.findElement(By.xpath(key));
        }

        File screenshot = (aiDriver.androidDriver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        Point point = element.getLocation();
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        File screenshotCropped = new File("ai-config/images/" + elementKey + ".png");
        FileUtils.copyFile(screenshot, screenshotCropped);
        screenshot.delete();

        return screenshotCropped;
    }
}
