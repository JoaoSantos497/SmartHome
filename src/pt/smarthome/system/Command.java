package pt.smarthome.system;

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

    public String generateMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append(deviceType)
                .append(":")
                .append(deviceId)
                .append(":")
                .append(action);

        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(":")
                    .append(entry.getKey())
                    .append("=")
                    .append(entry.getValue());
        }

        return sb.toString();
    }
}
