package settings;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Devices {
    public static HashMap<String, Boolean> devices = new HashMap<>();

    public static void initiliaze(Environment env) {
        for (JsonElement device : env.devices) {
            devices.put(device.getAsJsonObject().get("name").getAsString(), true);
        }
    }

    public static String getAvailableDevice() {
        for (String name : devices.keySet()) {
            if (devices.get(name)){
                devices.replace(name,false);
                return name;
            }
        }
        return null;
    }

    public static void setDeviceAvailable(String alias){
        devices.replace(alias,true);
    }
}
