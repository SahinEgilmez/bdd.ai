package steps;

import io.appium.java_client.MobileElement;
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
    public void clickByImage(String elementKey) throws Exception {
        MobileElement element = seeByImage(elementKey);
        element.click();
    }

    @When("^(?:I will )?see img:(\\w+(?: \\w+)*)")
    public MobileElement seeByImage(String elementKey) throws Exception {
        String path = "ai-config/images/" + elementKey.replace(" ", "_") + ".png";
        MobileElement element = (MobileElement) androidDriver.findElementByImage(getReferenceImageB64(path));
        System.out.println(element.toString());
        System.out.println(element.getLocation().x);
        System.out.println(element.getLocation().y);

        if (element.isDisplayed())
            return element;
        else
            throw new Exception("NOT FOUND IMAGE");
    }

    private boolean compareImageAndElement(MobileElement element,String pngPath) throws IOException {
        BufferedImage bimg = ImageIO.read(new File(pngPath));
        int width          = bimg.getWidth();
        int height         = bimg.getHeight();
        System.out.println("PNG size:" + width + " " + height);
        int elemWidth = element.getSize().getWidth();
        int elemHeight = element.getSize().getHeight();
        System.out.println("Element size:" + elemWidth + " " + elemHeight);
        return true;
    }

    private String getReferenceImageB64(String path) throws IOException {
        File refImgFile = new File(path);
        return Base64.getEncoder().encodeToString(Files.readAllBytes(refImgFile.toPath()));
    }

    @When("^(?:I will )?get (\\w+(?: \\w+)*) SS by (id|xpath):((?:\"[^\"]*\")+)$")
    public File getSSByElement(String elementKey, String by, String key) throws IOException {
        MobileElement element = null;
        key = key.replace("\"", "");
        if (by.equals("id"))
            element = (MobileElement) androidDriver.findElement(By.id(key));
        else if (by.equals("xpath")) {
            element = (MobileElement) androidDriver.findElement(By.xpath(key));
        }

        File screenshot = (androidDriver).getScreenshotAs(OutputType.FILE);
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

    @Before
    public void setUp() throws MalformedURLException {
        aiDriver.setUp();
    }

    @After
    public void tearDown() {
        aiDriver.tearDown();
    }
}
