package pt.smarthome.devices;

import pt.smarthome.core.SmartDevice;
import pt.smarthome.system.Connection;

public class AirConditioner extends SmartDevice {

    public AirConditioner(int id, String name, Connection connection) {
        super(id, name, connection);
    }

    @Override
    public void turnOn() {
        connection.sendCommand("AC:" + this.id + ":ON");
    }

    @Override
    public void turnOff() {
        connection.sendCommand("AC:" + this.id + ":OFF");
    }

    public void setTemperature(int temp) {
        connection.sendCommand("AC:" + this.id + ":TEMP:" + temp);
    }
}