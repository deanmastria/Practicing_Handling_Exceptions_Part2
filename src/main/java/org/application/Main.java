package org.example;

public class Main {
    public static void main(String[] args) {
        // Demonstrating StandardSensor
        StandardSensor ten = new StandardSensor(10);
        StandardSensor minusFive = new StandardSensor(-5);

        System.out.println("StandardSensor:");
        System.out.println("Reading from ten: " + ten.read());
        System.out.println("Reading from minusFive: " + minusFive.read());
        System.out.println("Is ten on? " + ten.isOn());
        ten.setOff();
        System.out.println("Is ten on after setOff? " + ten.isOn());

        // Demonstrating TemperatureSensor
        TemperatureSensor tempSensor = new TemperatureSensor();
        System.out.println("\nTemperatureSensor:");
        System.out.println("Is tempSensor on? " + tempSensor.isOn());
        tempSensor.setOn();
        System.out.println("Is tempSensor on after setOn? " + tempSensor.isOn());

        System.out.println("Reading temperatures:");
        for (int i = 0; i < 5; i++) {
            System.out.println(tempSensor.read());
        }

        tempSensor.setOff();
        try {
            System.out.println("Reading after turning off: " + tempSensor.read());
        } catch (IllegalStateException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
