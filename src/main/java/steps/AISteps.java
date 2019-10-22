package steps;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.NotFoundException;
import settings.AIDriver;

import java.net.MalformedURLException;
import java.util.logging.Logger;

/**
 * @author segilmez: Sahin Egilmez
 */
public class AISteps {
    private Logger LOGGER = Logger.getLogger(AISteps.class.getName());
    public AIDriver aiDriver;

    public AISteps() throws MalformedURLException {
        aiDriver = AIDriver.getInstance();
    }

    public void clickByAI(String elementKey) {
        aiDriver.androidDriver.findElement("-custom", "ai:" + elementKey).click();
    }

    public void seeByAI(String elementKey) {
        MobileElement elem = (MobileElement) aiDriver.androidDriver.findElementByCustom("ai:" + elementKey);
        if (elem == null)
            throw new NotFoundException("Not found exception:" + "ai:" + elementKey);
    }
}
