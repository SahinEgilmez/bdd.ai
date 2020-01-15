package steps;


import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import settings.BDDDriver;

import java.io.IOException;

/**
 * @author segilmez: Sahin Egilmez
 */
public class BDDProxy {
    private AISteps aiSteps;
    private ImageSteps imageSteps;
    private CommonSteps commonSteps;
    private BDDDriver bddDriver;

    public BDDProxy() {
        bddDriver = new BDDDriver();
        this.aiSteps = new AISteps(bddDriver);
        this.imageSteps = new ImageSteps(bddDriver);
        this.commonSteps = new CommonSteps(bddDriver);
    }

    @When("^(?:I )?launch device (\\w+(?: \\w+)*)$")
    public void launchDevice(String alias) throws Exception {
        bddDriver.launchDevice(alias);
    }

    @When("^(?:I )?launch any device$")
    public void launchAnyDevice() throws Exception {
        bddDriver.launchAnyDevice();
    }

    @When("^(?:I )?see ai:(\\w+(?: \\w+)*)$")
    public void seeByAI(String elementKey) throws Exception {
        aiSteps.seeByAI(elementKey);
    }

    @When("^(?:I )?see ai:(\\w+(?: \\w+)*) in ([0-9]*\\.[0-9]*) seconds$")
    public void seeByAINSeconds(String elementKey, Double seconds) throws Exception {
        aiSteps.seeByAINSeconds(elementKey, seconds);
    }

    @When("^(?:I )?click ai:(\\w+(?: \\w+)*)$")
    public void clickByAI(String elementKey) throws Exception {
        aiSteps.clickByAI(elementKey);
    }

    @When("^(?:I )?click ai:(\\w+(?: \\w+)*) in ([0-9]*\\.[0-9]*) seconds$")
    public void clickByAINSeconds(String elementKey, Double seconds) throws Exception {
        aiSteps.clickByAINSeconds(elementKey, seconds);
    }

    @When("^(?:I )?click img:(\\w+(?: \\w+)*)")
    public void clickByImage(String elementKey) throws Exception {
        imageSteps.clickByImage(elementKey);
    }

    @When("^(?:I )?click img:(\\w+(?: \\w+)*) with ([0-9]*\\.[0-9]*) threshold$")
    public void clickByImageWithThreshold(String elementKey, double threshold) throws Exception {
        imageSteps.clickByImageWithThreshold(elementKey, threshold);
    }

    @When("^(?:I )?see img:(\\w+(?: \\w+)*)")
    public void seeByImage(String elementKey) throws Exception {
        imageSteps.seeByImage(elementKey);
    }

    @When("^(?:I )?see img:(\\w+(?: \\w+)*) in ([0-9]*\\.[0-9]*) seconds$")
    public void seeByImageNSeconds(String elementKey, Double seconds) throws Exception {
        imageSteps.seeByImageNSeconds(elementKey, seconds);
    }

    @When("^(?:I )?see img:(\\w+(?: \\w+)*) with ([0-9]*\\.[0-9]*) threshold$")
    public void seeByImageWithThreshold(String elementKey, double threshold) throws Exception {
        imageSteps.seeByImageWithThreshold(elementKey, threshold);
    }

    @When("^(?:I do not )?see img:(\\w+(?: \\w+)*)")
    public void notSeeByImage(String elementKey) throws Exception {
        imageSteps.notSeeByImage(elementKey);
    }

    @When("^(?:I do not )?see img:(\\w+(?: \\w+)*) with ([0-9]*\\.[0-9]*) threshold$")
    public void notSeeByImageWithThreshold(String elementKey, double threshold) throws Exception {
        imageSteps.notSeeByImageWithThreshold(elementKey, threshold);
    }

    @When("^(?:I )?click (\\w+(?: \\w+)*)$")
    public void clickByID(String id) {
        commonSteps.clickByID(id);
    }

    @When("^(?:I )?see (\\w+(?: \\w+)*)$")
    public void seeByID(String id) {
        commonSteps.seeByID(id);
    }

    @When("^(?:I )?click ((?:\"[^\"]*\")+)$")
    public void clickByText(String text) throws Exception {
        commonSteps.clickByText(text);
    }

    @When("^(?:I )?long press ((?:\"[^\"]*\")+)$")
    public void longPressByText(String text) {
        commonSteps.longPressByText(text);
    }

    @When("^(?:I )?see ((?:\"[^\"]*\")+)$")
    public void seeByText(String text) throws Exception {
        commonSteps.seeByText(text);
    }

    @When("^(?:I do not )?see ((?:\"[^\"]*\")+)$")
    public void notSeeByText(String text) throws Exception {
        commonSteps.notSeeByText(text);
    }

    @When("^(?:I )?wait (\\d+) seconds?$")
    public void waitForNSeconds(int seconds) {
        CommonSteps.waitForNSeconds(seconds);
    }

    @When("^(?:I )?hide keyboard$")
    public void hideKeyboard() {
        commonSteps.hideKeyboard();
        waitForNSeconds(1);
    }

    @When("^(?:I )?enter (\\w+(?: \\w+)*)$")
    public void sendKeys(String text) {
        commonSteps.sendKeys(text);
    }

    @When("^(?:I )?swipe (up|down|left|right)$")
    public void swipe(String direction) throws Exception {
        commonSteps.swipe(direction);
    }

    @When("^(?:I )?get (\\w+(?: \\w+)*) SS by (id|xpath):((?:\"[^\"]*\")+)$")
    public void getSSByElement(String elementKey, String by, String key) throws IOException {
        imageSteps.getSSByElement(elementKey, by, key);
    }

    @Before
    public void setUp() {
        bddDriver.setUp();
    }

    @After(order = 1)
    public void tearDown() {
        bddDriver.tearDown();
    }

    @After(order = 2)
    public void embedScreenshot(Scenario scenario) {
        bddDriver.embedScreenshot(scenario);
    }
}
