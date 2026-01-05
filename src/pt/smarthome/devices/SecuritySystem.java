package pt.smarthome.devices;

import pt.smarthome.core.SmartDevice;
import pt.smarthome.system.Command;
import pt.smarthome.system.Connection;

public class SecuritySystem extends SmartDevice {

    private static final String DEVICE_TYPE = "ALARM";
    private static final String ACTION_ARM = "ARM";
    private static final String ACTION_DISARM = "DISARM";
    private static final String ACTION_PANIC = "PANIC";

    public SecuritySystem(int id, String name, Connection connection) {
        super(id, name, connection);
    }

    @Override
    public void turnOn() {
        System.out.println("A armar o sistema de segurança...");
        final var command = new Command(DEVICE_TYPE, id, ACTION_ARM);
        connection.sendCommand(command);
    }

    @Override
    public void turnOff() {
        System.out.println("A desarmar o sistema...");
        final var command = new Command(DEVICE_TYPE, id, ACTION_DISARM);
        connection.sendCommand(command);
    }

    public void triggerPanic() {
        final var command = new Command(DEVICE_TYPE, id, ACTION_PANIC);
        connection.sendCommand(command);
    }
}