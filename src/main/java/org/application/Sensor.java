package org.application;

public interface Sensor {
    //returns true if sensor is on
    boolean isOn();
    //sets sensor on
    void setOn();
    //Sets sensor off
    void setOff();
    //Returns value of sensor if on
    //ThrowsIllegalState Exception
    int read();
}