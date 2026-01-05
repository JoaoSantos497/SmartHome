package pt.smarthome.core;

import pt.smarthome.system.Connection;

public abstract class SmartDevice {
    protected int id;
    protected String name;
    protected Connection connection;

    public SmartDevice(int id, String name, Connection connection) {
        this.id = id;
        this.name = name;
        this.connection = connection;
    }

    // Métodos que todos os dispositivos têm de ter
    public abstract void turnOn();
    public abstract void turnOff();

    public String getName() {
        return name;
    }
}