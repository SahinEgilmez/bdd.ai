package steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import settings.AIDriver;

import java.net.MalformedURLException;

/**
 * @author segilmez: Sahin Egilmez
 */
public class CommonSteps {
    public AIDriver aiDriver;
    public AndroidDriver androidDriver;

    public CommonSteps() throws MalformedURLException {
        aiDriver = AIDriver.getInstance();
        androidDriver = aiDriver.androidDriver;
    }

    @When("^(?:I will )?wait (\\d+) seconds?$")
    public static void waitForNSeconds(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000L);
        } catch (InterruptedException var3) {
            throw new RuntimeException("Interrupted");
        }
    }

    @When("^(?:I will )?click ((?:\"[^\"]*\")+)$")
    public void clickByText(String text) {
        androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']").click();
    }

    @When("^(?:I will )?see ((?:\"[^\"]*\")+)$")
    public void seeByText(String text) {
        androidDriver.findElementByXPath("//*[@text='" + text.replace("\"", "") + "']");
    }

    @When("^(?:I will )?hide keyboard$")
    public void hideKeyboard() {
        androidDriver.hideKeyboard();
    }

    @When("^(?:I will )?enter (\\w+(?: \\w+)*)$")
    public void sendKeys(String text) {
        androidDriver.getKeyboard().sendKeys(text);
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
