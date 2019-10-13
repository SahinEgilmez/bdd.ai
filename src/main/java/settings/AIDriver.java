package settings;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AIDriver {
    private AppiumDriver appiumDriver = null;
    public AndroidDriver androidDriver = null;
    private IOSDriver iosDriver = null;
    private static AIDriver instance = null;

    private AIDriver() throws MalformedURLException, NotImplementedException {
        Environment environment = getEnvironment();
        if (environment.type.toLowerCase().equals("android")) {
            androidInitializer(environment, 0);
        } else {
            System.out.println("Currently developed only for Android.");
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
        JsonObject device = environment.devices.get(deviceNo).getAsJsonObject();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("name", "Test Automation");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("deviceName", device.get("udid").getAsString());
        capabilities.setCapability("appPackage", environment.appPackage);
        capabilities.setCapability("appActivity", environment.appActivity);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("testaiConfidenceThreshold", environment.testaiConfidenceThreshold);
        if (environment.appPath != null)
            capabilities.setCapability("app", environment.appPath);
        HashMap<String, String> customFindModules = new HashMap<>();
        customFindModules.put("ai", "test-ai-classifier");
        capabilities.setCapability("customFindModules", customFindModules);
        capabilities.setCapability("shouldUseCompactResponses", false);
        URL url = new URL(device.get("appiumURL").getAsString());
        androidDriver = new AndroidDriver(url, capabilities);
        androidDriver.manage().timeouts().implicitlyWait(environment.elementTimeout, TimeUnit.SECONDS);
        androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, environment.imageMatchThreshold);
    }

    private Environment getEnvironment() {
        JsonObject settings;
        Environment environment = null;
        try {
            FileReader fileReader = new FileReader("settings.json");
            Gson gson = new Gson();
            settings = JsonParser.parseReader(fileReader).getAsJsonObject();
            environment = gson.fromJson(settings.getAsJsonObject("environments").get("mobile"), Environment.class);
        } catch (FileNotFoundException e) {
            System.out.println("Not found settings file:" + e);
        }
        return environment;
    }

    /**
     * Run before each test
     */
    @Before
    public void setUp() throws MalformedURLException {
        if (androidDriver.getSessionId() == null){
            androidInitializer(getEnvironment(),0);
        }
    }

    /**
     * Run after each test *
     */
    @After
    public void tearDown() {
        if (appiumDriver != null) appiumDriver.quit();
        if (androidDriver != null) androidDriver.quit();
        if (iosDriver != null) iosDriver.quit();
    }
}
