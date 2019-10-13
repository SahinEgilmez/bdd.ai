package steps;

import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import settings.AIDriver;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * @author segilmez: Sahin Egilmez
 */
public class AISteps {
    public AIDriver aiDriver;
    public AndroidDriver androidDriver;

    public AISteps() throws MalformedURLException {
        aiDriver = AIDriver.getInstance();
        androidDriver = aiDriver.androidDriver;
    }

    @When("^(?:I will )?click ai:(\\w+(?: \\w+)*)$")
    public void clickByAI(String elementKey) {
        androidDriver.findElement("-custom", "ai:" + elementKey).click();
    }

    @When("^(?:I will )?see ai:(\\w+(?: \\w+)*)$")
    public void seeByAI(String elementKey) {
        MobileElement elem = (MobileElement) androidDriver.findElementByCustom("ai:" + elementKey);
        if (elem == null)
            throw new NotFoundException("Not found exception:" + "ai:" + elementKey);
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
