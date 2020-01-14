package settings;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

public class Environment {
    private static Logger LOGGER = Logger.getLogger(Environment.class.getName());
    public String type;
    public String appPath;
    public String appPackage;
    public String appActivity;
    public Double testaiConfidenceThreshold;
    public Double imageMatchThreshold;
    public Integer baseScreenWidth;
    public Integer baseScreenHeight;
    public Integer elementTimeout;
    public Double platformVersion;
    public JsonArray devices;
    public Integer threadCount;
    public String tags;
    public Boolean quickReport;
    private static Environment instance;

    public static Environment getInstance() {
        if (instance == null) {
            instance = getEnvironment();
        }
        return instance;
    }

    private static Environment getEnvironment() {
        JsonObject settings;
        try {
            FileReader fileReader = new FileReader("bdd-config/settings.json");
            Gson gson = new Gson();
            settings = JsonParser.parseReader(fileReader).getAsJsonObject();
            return gson.fromJson(settings.getAsJsonObject("environments").get("mobile"), Environment.class);
        } catch (FileNotFoundException e) {
            LOGGER.warning("Not found settings file:" + e);
        }
        return null;
    }
}
