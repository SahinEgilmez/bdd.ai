package settings;

import com.google.gson.JsonArray;

public class Environment {
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
}
