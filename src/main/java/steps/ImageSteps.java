package steps;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import settings.AIDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.Base64;

/**
 * @author segilmez: Sahin Egilmez
 */
public class ImageSteps {
    public AIDriver aiDriver;
    public AndroidDriver androidDriver;

    public ImageSteps() throws MalformedURLException {
        aiDriver = AIDriver.getInstance();
        androidDriver = aiDriver.androidDriver;
    }

    @When("^(?:I will )?click img:(\\w+(?: \\w+)*)")
    public void clickByImage(String elementKey) throws IOException {
        MobileElement element = seeByImage(elementKey);
        element.click();
    }

    @When("^(?:I will )?see img:(\\w+(?: \\w+)*)")
    public MobileElement seeByImage(String elementKey) throws IOException {
        String path = "images/" + elementKey.replace(" ", "_") + ".png";
        MobileElement element = (MobileElement) androidDriver.findElementByImage(getReferenceImageB64(path));
        return element;
    }

    private String getReferenceImageB64(String path) throws IOException {
        File refImgFile = new File(path);
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    public File getSSByElement(String elementKey, String xpath) throws IOException {
        MobileElement element = (MobileElement) androidDriver.findElement(By.xpath(xpath));

        File screenshot = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        Point point = element.getLocation();
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        File screenshotCropped = new File("images/" + elementKey + ".png");
        FileUtils.copyFile(screenshot, screenshotCropped);
        screenshot.delete();

        return screenshotCropped;
    }

    @Before
    public void setUp() throws MalformedURLException {
        aiDriver.setUp();
    }

    @After
    public void tearDown() throws Exception {
        aiDriver.tearDown();
    }
}
