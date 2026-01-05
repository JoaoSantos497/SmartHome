package pt.smarthome.devices;

import pt.smarthome.core.SmartDevice;
import pt.smarthome.system.Command;
import pt.smarthome.system.Connection;

public class SmartLight extends SmartDevice {

    private static final String DEVICE_TYPE = "LIGHT";
    private static final String ACTION_ON = "ON";
    private static final String ACTION_OFF = "OFF";
    private static final String ACTION_SET = "SET";
    private static final String PARAM_BRIGHT = "BRIGHT";

    public SmartLight(int id, String name, Connection connection) {
        super(id, name, connection);
    }

    @Override
    public void turnOn() {
        // Envia: LIGHT:1:ON
        final var command = new Command(DEVICE_TYPE, id, ACTION_ON);
        connection.sendCommand(command);
    }

    @Override
    public void turnOff() {
        // Envia: LIGHT:1:OFF
        final var command = new Command(DEVICE_TYPE, id, ACTION_OFF);
        connection.sendCommand(command);
    }

    public void setBrightness(int level) {
        // Envia: LIGHT:1:BRIGHT:50
        final var command = new Command(DEVICE_TYPE, id, ACTION_SET);
        command.addParam(PARAM_BRIGHT, Integer.toString(level));
        connection.sendCommand(command);
    }
}