package settings;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BDDDriver {
    private Logger LOGGER = Logger.getLogger(BDDDriver.class.getName());
    private AppiumDriver<MobileElement> appiumDriver = null;
    public AndroidDriver<MobileElement> androidDriver = null;
    private IOSDriver<MobileElement> iosDriver = null;
    public Environment environment;

    public BDDDriver() throws MalformedURLException, NotImplementedException {
        this.environment = Environment.getInstance();
    }

    public void launchDevice(String deviceName) throws Exception {
        LOGGER.info("ANDROID INIT");
        JsonObject device = null;
        for (JsonElement element : environment.devices) {
            if (element.getAsJsonObject().get("name").getAsString().equals(deviceName)) {
                device = element.getAsJsonObject();
                break;
            }
        }
        if (device == null) throw new Exception("Device not found!");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("name", "BDD Test Automation");
        capabilities.setCapability("automationName", "UIAutomator2");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", device.get("udid").getAsString());
        capabilities.setCapability("udid", device.get("udid").getAsString());
        capabilities.setCapability("systemPort", device.get("systemPort").getAsString());
        capabilities.setCapability("appPackage", environment.appPackage);
        capabilities.setCapability("appActivity", environment.appActivity);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("testaiConfidenceThreshold", environment.testaiConfidenceThreshold);
        if (environment.appPath != null && environment.appPath.equals(""))
            capabilities.setCapability("app", environment.appPath);
        HashMap<String, String> customFindModules = new HashMap<>();
        customFindModules.put("ai", "test-ai-classifier");
        capabilities.setCapability("customFindModules", customFindModules);
        capabilities.setCapability("shouldUseCompactResponses", false);
        capabilities.setCapability("testaiFindMode", "object_detection");
        capabilities.setCapability("testaiObjDetectionDebug", true);

        URL appiumUrl = new URL(device.get("appiumURL").getAsString());
        androidDriver = new AndroidDriver(appiumUrl, capabilities);
        androidDriver.manage().timeouts().implicitlyWait(environment.elementTimeout, TimeUnit.SECONDS);
        androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, environment.imageMatchThreshold);
    }

    /**
     * Run before each test
     */
    public void setUp() throws MalformedURLException {
        LOGGER.info("setUp");
        //if (androidDriver == null) androidInitializer(getEnvironment(), 0);
    }

    /**
     * Run after each test *
     */
    public void tearDown() {
        LOGGER.info("tearDown");
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
        if (androidDriver != null) {
            androidDriver.quit();
            androidDriver = null;
        }
        if (iosDriver != null) {
            iosDriver.quit();
            iosDriver = null;
        }
    }
}
