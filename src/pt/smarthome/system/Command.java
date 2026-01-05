package pt.smarthome.system;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Command {

    private final String deviceType;
    private final int deviceId;
    private final String action;
    private final Map<String, String> params;

    public Command(String deviceType, int deviceId, String action) {
        this.deviceType = deviceType;
        this.deviceId = deviceId;
        this.action = action;
        this.params = new HashMap<>();
    }

    public Command addParam(String key, String value) {
        params.put(key, value);
        return this;
    }

    public String getDeviceType() {

        return deviceType;
    }

    public int getDeviceId() {

        return deviceId;
    }

    public String getAction() {

        return action;
    }

    public Map<String, String> getParams() {
        return Collections.unmodifiableMap(params);
    }
}
