package steps;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import settings.BDDDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

/**
 * @author segilmez: Sahin Egilmez
 */
public class BDDProxy {
    private AISteps aiSteps;
    private ImageSteps imageSteps;
    private CommonSteps commonSteps;
    private BDDDriver bddDriver;
    private Logger LOGGER = Logger.getLogger(BDDProxy.class.getName());

    public BDDProxy() throws MalformedURLException {
        bddDriver = new BDDDriver();
        this.aiSteps = new AISteps(bddDriver);
        this.imageSteps = new ImageSteps(bddDriver);
        this.commonSteps = new CommonSteps(bddDriver);
    }

    @When("^(?:I will )?launch device (\\w+(?: \\w+)*)$")
    public void launchDevice(String alias) throws Exception {
        commonSteps.launchDevice(alias);
    }


    @When("^(?:I will )?see ai:(\\w+(?: \\w+)*)$")
    public void seeByAI(String elementKey) throws Exception {
        aiSteps.seeByAI(elementKey);
    }

    @When("^(?:I will )?see ai:(\\w+(?: \\w+)*) in ([0-9]*\\.[0-9]*) seconds$")
    public void seeByAINSeconds(String elementKey, Double seconds) throws Exception {
        aiSteps.seeByAINSeconds(elementKey, seconds);
    }

    @When("^(?:I will )?click ai:(\\w+(?: \\w+)*)$")
    public void clickByAI(String elementKey) throws Exception {
        aiSteps.clickByAI(elementKey);
    }

    @When("^(?:I will )?click ai:(\\w+(?: \\w+)*) in ([0-9]*\\.[0-9]*) seconds$")
    public void clickByAINSeconds(String elementKey, Double seconds) throws Exception {
        aiSteps.clickByAINSeconds(elementKey, seconds);
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

    @When("^(?:I will )?see img:(\\w+(?: \\w+)*) in ([0-9]*\\.[0-9]*) seconds$")
    public void seeByImageNSeconds(String elementKey, Double seconds) throws Exception {
        imageSteps.seeByImageNSeconds(elementKey, seconds);
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

    @When("^(?:I will )?click ((?:\"[^\"]*\")+)$")
    public void clickByText(String text) {
        commonSteps.clickByText(text);
    }

    @When("^(?:I will )?long press ((?:\"[^\"]*\")+)$")
    public void longPressByText(String text) {
        commonSteps.longPressByText(text);
    }

    @When("^(?:I will )?see ((?:\"[^\"]*\")+)$")
    public void seeByText(String text) throws Exception {
        commonSteps.seeByText(text);
    }

    @When("^(?:I will not )?see ((?:\"[^\"]*\")+)$")
    public void notSeeByText(String text) throws Exception {
        commonSteps.notSeeByText(text);
    }

    @When("^(?:I will )?wait (\\d+) seconds?$")
    public void waitForNSeconds(int seconds) {
        CommonSteps.waitForNSeconds(seconds);
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

    @When("^(?:I will )?get (\\w+(?: \\w+)*) SS by (id|xpath):((?:\"[^\"]*\")+)$")
    public void getSSByElement(String elementKey, String by, String key) throws IOException {
        imageSteps.getSSByElement(elementKey, by, key);
    }

    @Before
    public void setUp() throws MalformedURLException {
        bddDriver.setUp();
    }

    @After(order = 1)
    public void tearDown() throws MalformedURLException {
        bddDriver.tearDown();
    }

    @After(order = 2)
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) bddDriver.androidDriver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
