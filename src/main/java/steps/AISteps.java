package steps;

import io.appium.java_client.MobileElement;
import settings.BDDDriver;
import settings.Environment;

import java.util.List;

/**
 * @author segilmez: Sahin Egilmez
 */
public class AISteps {
    public BDDDriver bddDriver;

    public AISteps(BDDDriver bddDriver) {
        this.bddDriver = bddDriver;
    }

    public void seeByAI(String elementKey) throws Exception {
        int timeout = Environment.getInstance().elementTimeout;
        seeByAINSeconds(elementKey, timeout);
    }

    public void seeByAINSeconds(String elementKey, double timeout) throws Exception {
        long tStart = System.currentTimeMillis();
        double elapsedSeconds;
        do {
            MobileElement elem = bddDriver.currentDriver().findElementByCustom("ai:" + elementKey);
            if (elem != null) { //if elements exist
                return;
            }
            elapsedSeconds = (System.currentTimeMillis() - tStart) / 1000.0;
        } while (!(elapsedSeconds >= timeout));
        throw new Exception("I cannot see AI element:" + elementKey);
    }

    public void clickByAI(String elementKey) throws Exception {
        int timeout = Environment.getInstance().elementTimeout;
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
        List<MobileElement> elements = bddDriver.currentDriver().findElements("-custom", "ai:" + elementKey);
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
