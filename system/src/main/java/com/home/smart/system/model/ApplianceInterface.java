package com.home.smart.system.model;

public interface ApplianceInterface {
    public void turnOn();
    public void turnOff();
    public boolean status();
    public boolean isAppliance(String uuid);
}
