package com.home.smart.system.model;

import com.home.smart.system.enums.Category;

public class Light extends Device implements ApplianceInterface {
    
    private boolean on;

    public Light(String name, Category category) {
        super(name, category);
        this.on = Boolean.FALSE;
    }

    @Override
    public void turnOn() {
        this.on = Boolean.TRUE;
    }

    @Override
    public void turnOff() {
        this.on = Boolean.FALSE;
    }

    @Override
    public boolean status() {
        return this.on;
    }
    
    @Override
    public boolean isAppliance(String uuid) {
        return getId().toString().equals(uuid);
    }
}
