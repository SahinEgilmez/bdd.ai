package settings;

import com.google.gson.Gson;
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

public class AIDriver {
    private Logger LOGGER = Logger.getLogger(AIDriver.class.getName());
    private AppiumDriver<MobileElement> appiumDriver = null;
    public AndroidDriver<MobileElement> androidDriver = null;
    private IOSDriver<MobileElement> iosDriver = null;
    private static AIDriver instance = null;
    public Environment environment;

    private AIDriver() throws MalformedURLException, NotImplementedException {
        this.environment = getEnvironment();
        if (environment.type.toLowerCase().equals("android")) {
            androidInitializer(environment, 0);
        } else {
            LOGGER.warning("Currently developed only for Android.");
            throw new NotImplementedException();
        }
    }

    public static AIDriver getInstance() throws MalformedURLException {
        if (instance == null) {
            instance = new AIDriver();
        }
        return instance;
    }

    private void androidInitializer(Environment environment, int deviceNo) throws MalformedURLException {
        LOGGER.info("ANDROID INIT");
        JsonObject device = environment.devices.get(deviceNo).getAsJsonObject();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("name", "BDD Test Automation");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", device.get("udid").getAsString());
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

    private Environment getEnvironment() {
        JsonObject settings;
        Environment environment = null;
        try {
            FileReader fileReader = new FileReader("bdd-config/settings.json");
            Gson gson = new Gson();
            settings = JsonParser.parseReader(fileReader).getAsJsonObject();
            environment = gson.fromJson(settings.getAsJsonObject("environments").get("mobile"), Environment.class);
        } catch (FileNotFoundException e) {
            LOGGER.warning("Not found settings file:" + e);
        }
        return environment;
    }

    /**
     * Run before each test
     */
    public void setUp() throws MalformedURLException {
        LOGGER.info("setUp");
        if (androidDriver == null)
            androidInitializer(getEnvironment(), 0);
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
