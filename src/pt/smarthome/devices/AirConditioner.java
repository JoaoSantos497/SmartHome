package pt.smarthome.devices;

import pt.smarthome.core.SmartDevice;
import pt.smarthome.system.Command;
import pt.smarthome.system.Connection;

public class AirConditioner extends SmartDevice {

    private static final String DEVICE_TYPE = "AC";
    private static final String ACTION_ON = "ON";
    private static final String ACTION_OFF = "OFF";
    private static final String ACTION_SET = "SET";
    private static final String PARAM_TEMP = "TEMP";

    public AirConditioner(int id, String name, Connection connection) {
        super(id, name, connection);
    }

    @Override
    public void turnOn() {
        final var command = new Command(DEVICE_TYPE, id, ACTION_ON);
        connection.sendCommand(command);
    }

    @Override
    public void turnOff() {
        final var command = new Command(DEVICE_TYPE, id, ACTION_OFF);
        connection.sendCommand(command);
    }

    public void setTemperature(int temp) {
        final var command = new Command(DEVICE_TYPE, id, ACTION_SET);
        command.addParam(PARAM_TEMP, Integer.toString(temp));
        connection.sendCommand(command);
    }
}