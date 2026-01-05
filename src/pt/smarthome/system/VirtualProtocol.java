package pt.smarthome.system;

import java.util.Map;

public class VirtualProtocol implements Protocol {

    @Override
    public String generate(Command command) {
        StringBuilder sb = new StringBuilder();
        sb.append(command.getDeviceType())
                .append(":")
                .append(command.getDeviceId())
                .append(":")
                .append(command.getAction());

        for (Map.Entry<String, String> entry : command.getParams().entrySet()) {
            sb.append(":")
                    .append(entry.getKey())
                    .append("=")
                    .append(entry.getValue());
        }

        return sb.toString();
    }
}
