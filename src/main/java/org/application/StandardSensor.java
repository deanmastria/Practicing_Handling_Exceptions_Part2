package org.application;

public class StandardSensor implements Sensor {
    private int value; //Fixed values the sensor returns

    //Constructor that initializes the sensor with a given value
    public StandardSensor(int value) {
        this.value = value;
    }

    //Always returns true as the standard sensor is always on
    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {
        // Do nothing, always on
    }

    @Override
    public void setOff() {
        // Do nothing, always on
    }
    //Returns the fixed value of the sensor
    @Override
    public int read() {
        return this.value;
    }

    public static void main(String[] args) {
        StandardSensor ten = new StandardSensor(10);
        StandardSensor minusFive = new StandardSensor(-5);

        System.out.println(ten.read());
        System.out.println(minusFive.read());

        System.out.println(ten.isOn());
        ten.setOff();
        System.out.println(ten.isOn());
    }
}

