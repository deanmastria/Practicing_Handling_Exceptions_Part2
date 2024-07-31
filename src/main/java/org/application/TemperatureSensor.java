package org.example;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean isOn; // Indicates whether the sensor is on
    private Random random; //Random number generator for simulatinf temp readings

    //Constructor initializes the sensor to be off, sets up random number generator
    public TemperatureSensor() {
        this.isOn = false;
        this.random = new Random();
    }

    //Returns true if sensor is on
    @Override
    public boolean isOn() {
        return this.isOn;
    }

    //Sets sensor to on
    @Override
    public void setOn() {
        this.isOn = true;
    }

    //sets sensor to off
    @Override
    public void setOff() {
        this.isOn = false;
    }

    //Returns random temp reading between -30 and 30 if sensor is on
    @Override
    public int read() {
        if (!this.isOn) {
            throw new IllegalStateException("The sensor is off.");
        }
        return this.random.nextInt(61) - 30;
    }

    public static void main(String[] args) {
        TemperatureSensor tempSensor = new TemperatureSensor();
        System.out.println(tempSensor.isOn()); // false
        tempSensor.setOn();
        System.out.println(tempSensor.isOn()); // true

        for (int i = 0; i < 5; i++) {
            System.out.println(tempSensor.read());
        }

        tempSensor.setOff();
        try {
            System.out.println(tempSensor.read());
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
