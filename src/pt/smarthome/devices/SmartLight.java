package pt.smarthome.devices;

import pt.smarthome.core.SmartDevice;
import pt.smarthome.system.Connection;

public class SmartLight extends SmartDevice {

    public SmartLight(int id, String name, Connection connection) {
        super(id, name, connection);
    }

    @Override
    public void turnOn() {
        // Envia: LIGHT:1:ON
        connection.sendCommand("LIGHT:" + this.id + ":ON");
    }

    @Override
    public void turnOff() {
        // Envia: LIGHT:1:OFF
        connection.sendCommand("LIGHT:" + this.id + ":OFF");
    }

    public void setBrightness(int level) {
        // Envia: LIGHT:1:BRIGHT:50
        connection.sendCommand("LIGHT:" + this.id + ":BRIGHT:" + level);
    }
}