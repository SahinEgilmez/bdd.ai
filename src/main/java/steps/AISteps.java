package steps;

import io.appium.java_client.MobileElement;
import settings.BDDDriver;

import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author segilmez: Sahin Egilmez
 */
public class AISteps {
    private Logger LOGGER = Logger.getLogger(AISteps.class.getName());
    public BDDDriver BDDDriver;

    public AISteps(BDDDriver bddDriver) throws MalformedURLException {
        BDDDriver = bddDriver;
    }

    public void seeByAI(String elementKey) throws Exception {
        int timeout = BDDDriver.environment.elementTimeout;
        seeByAINSeconds(elementKey, timeout);
    }

    public void seeByAINSeconds(String elementKey, double timeout) throws Exception {
        long tStart = System.currentTimeMillis();
        double elapsedSeconds;
        do {
            MobileElement elem = BDDDriver.androidDriver.findElementByCustom("ai:" + elementKey);
            if (elem != null) { //if elements exist
                return;
            }
            elapsedSeconds = (System.currentTimeMillis() - tStart) / 1000.0;
        } while (!(elapsedSeconds >= timeout));
        throw new Exception("I cannot see AI element:" + elementKey);
    }

    public void clickByAI(String elementKey) throws Exception {
        int timeout = BDDDriver.environment.elementTimeout;
        clickByAINSeconds(elementKey, timeout);
    }

    public void clickByAINSeconds(String elementKey, double timeout) throws Exception {
        long tStart = System.currentTimeMillis();
        double elapsedSeconds;
        do {
            if (clickAIElements(elementKey) > 0) { //if elements exist
                return;
            }
            elapsedSeconds = (System.currentTimeMillis() - tStart) / 1000.0;
        } while (!(elapsedSeconds >= timeout));
        throw new Exception("I cannot see AI element:" + elementKey);
    }

    private int clickAIElements(String elementKey) {
        List<MobileElement> elements = BDDDriver.androidDriver.findElements("-custom", "ai:" + elementKey);
        for (MobileElement element : elements) {
            try {
                element.click();
            } catch (Exception ignored) {
                //Ignore this exception
            }
        }
        return elements.size();
    }
}
