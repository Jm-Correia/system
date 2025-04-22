package com.home.smart.system.model;



import com.home.smart.system.enums.Category;
import com.home.smart.system.enums.ThermostatMode;

public class AirConditioner extends Device implements ActionACInterface {

    
    private ThermostatMode mode;
    
    public AirConditioner(String name, Category category) {
        super(name, category);
        this.mode = ThermostatMode.OFF;
    }

    @Override
    public void turnOn() {
        this.mode = ThermostatMode.COOL;
    }

    @Override
    public void turnOff() {
        this.mode = ThermostatMode.OFF;
    }

    @Override
    public boolean status() {
        return this.mode != ThermostatMode.OFF; // on = true off = false
    }

    @Override
    public void setThermostatMode(ThermostatMode mode) {
        this.mode = mode;
    }

    @Override
    public boolean isCooling() {
        return (this.mode != ThermostatMode.OFF && this.mode == ThermostatMode.COOL);
    }
 
    @Override
    public boolean isAppliance(String uuid) {
        return getId().toString().equals(uuid);
    }
    
}
