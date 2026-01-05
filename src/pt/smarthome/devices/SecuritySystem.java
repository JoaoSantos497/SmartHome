package pt.smarthome.devices;

import pt.smarthome.core.SmartDevice;
import pt.smarthome.system.Connection;

public class SecuritySystem extends SmartDevice {

    public SecuritySystem(int id, String name, Connection connection) {
        super(id, name, connection);
    }

    @Override
    public void turnOn() {
        System.out.println("A armar o sistema de segurança...");
        connection.sendCommand("ALARM:" + this.id + ":ARM");
    }

    @Override
    public void turnOff() {
        System.out.println("A desarmar o sistema...");
        connection.sendCommand("ALARM:" + this.id + ":DISARM");
    }

    public void triggerPanic() {
        connection.sendCommand("ALARM:" + this.id + ":PANIC");
    }
}