package steps;

import io.appium.java_client.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import settings.AIDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.logging.Logger;

import static java.time.Duration.ofMillis;
import static java.time.Duration.parse;

/**
 * @author segilmez: Sahin Egilmez
 */
public class BDDProxy {
    private AISteps aiSteps;
    private ImageSteps imageSteps;
    private CommonSteps commonSteps;

    public BDDProxy() throws MalformedURLException {
        this.aiSteps = new AISteps();
        this.imageSteps = new ImageSteps();
        this.commonSteps = new CommonSteps();
    }

    @When("^(?:I will )?click ai:(\\w+(?: \\w+)*)$")
    public void clickByAI(String elementKey) {
        aiSteps.clickByAI(elementKey);
    }

    @When("^(?:I will )?see ai:(\\w+(?: \\w+)*)$")
    public void seeByAI(String elementKey) {
        aiSteps.seeByAI(elementKey);
    }

    @When("^(?:I will )?wait (\\d+) seconds?$")
    public void waitForNSeconds(int seconds) {
        CommonSteps.waitForNSeconds(seconds);
    }

    @When("^(?:I will )?click ((?:\"[^\"]*\")+)$")
    public void clickByText(String text) {
        commonSteps.clickByText(text);
    }

    @When("^(?:I will )?see ((?:\"[^\"]*\")+)$")
    public void seeByText(String text) throws Exception {
        commonSteps.seeByText(text);
    }

    @When("^(?:I will not )?see ((?:\"[^\"]*\")+)$")
    public void notSeeByText(String text) throws Exception {
        commonSteps.notSeeByText(text);
    }

    @When("^(?:I will )?hide keyboard$")
    public void hideKeyboard() {
        commonSteps.hideKeyboard();
    }

    @When("^(?:I will )?enter (\\w+(?: \\w+)*)$")
    public void sendKeys(String text) {
        commonSteps.sendKeys(text);
    }

    @When("^(?:I will )?swipe (up|down|left|right)$")
    public void swipe(String direction) throws Exception {
        commonSteps.swipe(direction);
    }

    @When("^(?:I will )?click img:(\\w+(?: \\w+)*)")
    public void clickByImage(String elementKey) throws Exception {
        imageSteps.clickByImage(elementKey);
    }

    @When("^(?:I will )?click img:(\\w+(?: \\w+)*) with ([0-9]*\\.[0-9]*) threshold$")
    public void clickByImageWithThreshold(String elementKey, double threshold) throws Exception {
        imageSteps.clickByImageWithThreshold(elementKey, threshold);
    }

    @When("^(?:I will )?see img:(\\w+(?: \\w+)*)")
    public void seeByImage(String elementKey) throws Exception {
        imageSteps.seeByImage(elementKey);
    }

    @When("^(?:I will )?see img:(\\w+(?: \\w+)*) with ([0-9]*\\.[0-9]*) threshold$")
    public void seeByImageWithThreshold(String elementKey, double threshold) throws Exception {
        imageSteps.seeByImageWithThreshold(elementKey, threshold);
    }

    @When("^(?:I will not )?see img:(\\w+(?: \\w+)*)")
    public void notSeeByImage(String elementKey) throws Exception {
        imageSteps.notSeeByImage(elementKey);
    }

    @When("^(?:I will not )?see img:(\\w+(?: \\w+)*) with ([0-9]*\\.[0-9]*) threshold$")
    public void notSeeByImageWithThreshold(String elementKey, double threshold) throws Exception {
        imageSteps.notSeeByImageWithThreshold(elementKey, threshold);
    }

    @When("^(?:I will )?get (\\w+(?: \\w+)*) SS by (id|xpath):((?:\"[^\"]*\")+)$")
    public void getSSByElement(String elementKey, String by, String key) throws IOException {
        imageSteps.getSSByElement(elementKey, by, key);
    }

    @Before
    public void setUp() throws MalformedURLException {
        AIDriver.getInstance().setUp();
    }

    @After
    public void tearDown() throws MalformedURLException {
        AIDriver.getInstance().tearDown();
    }
}
