package steps;

import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Coordinates;
import settings.BDDDriver;
import settings.Environment;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author segilmez: Sahin Egilmez
 */
public class ImageSteps {
    private Logger LOGGER = Logger.getLogger(ImageSteps.class.getName());
    public BDDDriver bddDriver;

    public ImageSteps(BDDDriver bddDriver) {
        this.bddDriver = bddDriver;
    }

    public void clickByImage(String elementKey) throws Exception {
        MobileElement element = seeByImage(elementKey);
        element.click();
    }

    public void clickByImageWithThreshold(String elementKey, double threshold) throws Exception {
        double oldThreshold = setImageThreshold(threshold);
        seeByImage(elementKey).click();
        setImageThreshold(oldThreshold);
    }

    public MobileElement seeByImage(String elementKey) throws Exception {
        int timeout = Environment.getInstance().elementTimeout;
        return seeByImageNSeconds(elementKey, timeout);
    }

    public MobileElement seeByImageNSeconds(String elementKey, double timeout) throws Exception {
        String path = "bdd-config"+File.separator+"images"+File.separator + elementKey.replace(" ", "_") + ".png";
        long tStart = System.currentTimeMillis();
        double elapsedSeconds;
        do {
            try {
                MobileElement element = bddDriver.currentDriver().findElementByImage(getReferenceImageB64(path));
                if (element != null && element.isDisplayed())
                    return element;
            } catch (Exception e) {
                LOGGER.info("Ignored exception: " + e.getMessage().split("\n")[0]+"...");
            }
            elapsedSeconds = (System.currentTimeMillis() - tStart) / 1000.0;
        } while (!(elapsedSeconds >= timeout));
        throw new Exception("I cannot see image element:" + elementKey);
    }

    public void seeByImageWithThreshold(String elementKey, double threshold) throws Exception {
        double oldThreshold = setImageThreshold(threshold);
        seeByImage(elementKey);
        setImageThreshold(oldThreshold);
    }

    public void notSeeByImage(String elementKey) throws Exception {
        try {
            seeByImage(elementKey);
        } catch (Exception e) {
            LOGGER.info("Expected result: I didn't see " + elementKey + ".png");
            return;
        }
        throw new Exception("The element is visible, but we expected it not to.");
    }

    public void notSeeByImageWithThreshold(String elementKey, double threshold) throws Exception {
        double oldThreshold = setImageThreshold(threshold);
        notSeeByImage(elementKey);
        setImageThreshold(oldThreshold);
    }

    private double setImageThreshold(double threshold) throws Exception {
        double oldThreshold = bddDriver.getImageMatchThreshold();
        bddDriver.setImageMatchThreshold(threshold);
        return oldThreshold;
    }

    private String getReferenceImageB64(String path) throws IOException {
        File refImgFile = resizeBaseImage(new File(path));
        String base64 = Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
        refImgFile.delete();
        return base64;
    }

    private File resizeBaseImage(File baseImg) throws IOException {
        double screenWidth = Environment.getInstance().baseScreenWidth;
        double screenHeight = Environment.getInstance().baseScreenHeight;
        double width = bddDriver.currentDriver().manage().window().getSize().getWidth();
        double height = bddDriver.currentDriver().manage().window().getSize().getHeight();
        int newWidth = (int) ((width / screenWidth) * ImageIO.read(baseImg).getWidth());
        int newHeight = (int) ((height / screenHeight) * ImageIO.read(baseImg).getHeight());
        return resizeImage(baseImg, newWidth, newHeight);
    }

    private File resizeImage(File baseImg, int width, int height) throws IOException {
        Image img = ImageIO.read(baseImg);
        final BufferedImage tempPNG = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = tempPNG.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(img, 0, 0, width, height, null);
        graphics2D.dispose();
        File newFilePNG = new File(baseImg.getPath() + (new Random()).nextInt() + "_tmp.png");
        ImageIO.write(tempPNG, "png", newFilePNG);
        return newFilePNG;
    }

    public File getSSByElement(String imageName, String by, String elementKey) throws IOException {
        MobileElement element = null;
        elementKey = elementKey.replace("\"", "");
        if (by.equals("id"))
            element = (MobileElement) bddDriver.currentDriver().findElement(By.id(elementKey));
        else if (by.equals("xpath")) {
            element = (MobileElement) bddDriver.currentDriver().findElement(By.xpath(elementKey));
        }

        File screenshot = (bddDriver.currentDriver()).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        Coordinates point = element.getCoordinates();
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.onPage().getX(), point.onPage().getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        File screenshotCropped = new File("bdd-config/images/" + imageName + ".png");
        FileUtils.copyFile(screenshot, screenshotCropped);
        screenshot.delete();

        return screenshotCropped;
    }
}
