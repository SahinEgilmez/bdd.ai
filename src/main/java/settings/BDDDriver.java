package settings;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.hu.De;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BDDDriver {
    private Logger LOGGER = Logger.getLogger(BDDDriver.class.getName());
    private AndroidDriver<MobileElement> androidDriver = null;
    private IOSDriver<MobileElement> iosDriver = null;
    public Environment environment;
    private String currentDeviceName;

    public BDDDriver() throws NotImplementedException {
        this.environment = Environment.getInstance();
    }

    public void launchDevice(String alias) throws Exception {
        if (environment.type.toLowerCase().equals("android"))
            launchAndroidDevice(alias);
        else if (environment.type.toLowerCase().equals("ios"))
            launchIOSDevice(alias);
    }

    public void launchAnyDevice() throws Exception {
        String deviceName = Devices.getAvailableDevice();
        if (environment.type.toLowerCase().equals("android"))
            launchAndroidDevice(deviceName);
        else if (environment.type.toLowerCase().equals("ios"))
            launchIOSDevice(deviceName);
    }

    private void launchAndroidDevice(String deviceName) throws Exception {
        LOGGER.info("ANDROID INIT");
        JsonObject device = null;
        for (JsonElement element : environment.devices) {
            if (element.getAsJsonObject().get("name").getAsString().equals(deviceName)) {
                device = element.getAsJsonObject();
                break;
            }
        }
        if (device == null) throw new Exception("Device not found!");
        currentDeviceName = device.get("name").getAsString();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("name", "BDD Test Automation");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", device.get("udid").getAsString());
        capabilities.setCapability("udid", device.get("udid").getAsString());
        capabilities.setCapability("platformVersion", Environment.getInstance().platformVersion);
        capabilities.setCapability("systemPort", device.get("systemPort").getAsInt());
        capabilities.setCapability("appPackage", environment.appPackage);
        capabilities.setCapability("appActivity", environment.appActivity);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("testaiConfidenceThreshold", environment.testaiConfidenceThreshold);
        if (environment.appPath != null && !environment.appPath.equals(""))
            capabilities.setCapability("app", environment.appPath);
        HashMap<String, String> customFindModules = new HashMap<>();
        customFindModules.put("ai", "test-ai-classifier");
        capabilities.setCapability("customFindModules", customFindModules);
        capabilities.setCapability("shouldUseCompactResponses", false);
        capabilities.setCapability("testaiFindMode", "object_detection");
        capabilities.setCapability("testaiObjDetectionDebug", true);

        URL appiumUrl = new URL(device.get("appiumURL").getAsString());
        androidDriver = new AndroidDriver<MobileElement>(appiumUrl, capabilities);
        androidDriver.manage().timeouts().implicitlyWait(environment.elementTimeout, TimeUnit.SECONDS);
        androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, environment.imageMatchThreshold);
    }

    private void launchIOSDevice(String deviceName) throws Exception {
        throw  new Exception("Not implemented IOS devices.");
    }

    public AppiumDriver<MobileElement> currentDriver() {
        if (environment.type.toLowerCase().equals("android"))
            return androidDriver;
        else if (environment.type.toLowerCase().equals("ios"))
            return iosDriver;
        else
            return null;
    }

    public void setImageMatchThreshold(Double th) {
        if (environment.type.toLowerCase().equals("android")) {
            androidDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, th);
        } else if (environment.type.toLowerCase().equals("ios")) {
            iosDriver.setSetting(Setting.IMAGE_MATCH_THRESHOLD, th);
        }
    }

    public Double getImageMatchThreshold() throws Exception {
        if (environment.type.toLowerCase().equals("android")) {
            return (Double) androidDriver.getSettings().get("imageMatchThreshold");
        } else if (environment.type.toLowerCase().equals("ios")) {
            return (Double) iosDriver.getSettings().get("imageMatchThreshold");
        } else
            throw new Exception("Not found IMAGE_MATCH_THRESHOLD value.");
    }

    /**
     * Run before each test
     */
    public void setUp() {
        LOGGER.info("setUp");
    }

    /**
     * Run after each test *
     */
    public void tearDown() {
        LOGGER.info("tearDown");
        if (androidDriver != null) {
            androidDriver.quit();
            androidDriver = null;
        }
        if (iosDriver != null) {
            iosDriver.quit();
            iosDriver = null;
        }
        Devices.setDeviceAvailable(currentDeviceName);
    }

    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = (currentDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
