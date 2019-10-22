package settings;

import com.google.gson.JsonArray;

public class Environment {
    String type;
    String appPath;
    String appPackage;
    String appActivity;
    Double testaiConfidenceThreshold;
    Double imageMatchThreshold;
    Integer elementTimeout;
    Double platformVersion;
    JsonArray devices;
}
