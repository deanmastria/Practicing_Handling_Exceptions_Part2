package org.application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;   //List to store the individual sensors
    private List<Integer> readings; //List to store the history of average readings
    private boolean isOn;           //Flag to indicate whether the average sensor is on

    //Constructor initializes the lists and sets the sensor off
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
        this.isOn = false;
    }
    //Method to add a new sensor to the average sensor
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    //Method to check uf all sensors are on
    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }
    //Method to turn on all sensors
    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
        this.isOn = true;
    }

    //Method to turn off all sensors
    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
        this.isOn = false;
    }

    //Method to read the average value from all sensors
    @Override
    public int read() {
        if (!this.isOn || this.sensors.isEmpty()) {
            throw new IllegalStateException("The sensor is off or no sensors have been added.");
        }

        int sum = 0;
        for (Sensor sensor : sensors) {
            sum += sensor.read();
        }
        int average = sum / sensors.size(); //Calculate the average value
        readings.add(average); //Store the reading in the history list
        return average;
    }

    //Method to return history of readings
    public List<Integer> readings() {
        return new ArrayList<>(this.readings);
    }

    public static void main(String[] args) {
        //Create n TemperatureSensor object and turn it on
        Sensor wilmington = new TemperatureSensor();
        wilmington.setOn();
        System.out.println("Temperature in Wilmington: " + wilmington.read() + " degrees Celsius");

        //Additional tempsensor objects
        Sensor leland = new TemperatureSensor();
        Sensor ILMAirport = new TemperatureSensor();

        //Create an AverageSensor and add the TemperatureSensors to it
        AverageSensor eastCarolinaRegion = new AverageSensor();
        eastCarolinaRegion.addSensor(wilmington);
        eastCarolinaRegion.addSensor(leland);
        eastCarolinaRegion.addSensor(ILMAirport);

        //Turns on AverageSensors which turns on all sensors
        eastCarolinaRegion.setOn();
        System.out.println("Temperature in Helsinki region: " + eastCarolinaRegion.read() + " degrees Celsius");
        System.out.println("Temperature in Helsinki region: " + eastCarolinaRegion.read() + " degrees Celsius");
        System.out.println("Temperature in Helsinki region: " + eastCarolinaRegion.read() + " degrees Celsius");

        System.out.println("Readings: " + eastCarolinaRegion.readings());
    }
}
