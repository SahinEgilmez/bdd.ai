package settings;

import com.google.gson.JsonArray;

public class Environment {
    String type;
    String appPath;
    String appPackage;
    String appActivity;
    Integer testaiConfidenceThreshold;
    Integer imageMatchThreshold;
    Integer elementTimeout;
    Double platformVersion;
    JsonArray devices;
}
