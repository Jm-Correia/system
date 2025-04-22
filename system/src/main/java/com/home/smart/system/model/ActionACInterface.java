package com.home.smart.system.model;

import com.home.smart.system.enums.ThermostatMode;

public interface ActionACInterface extends ApplianceInterface {
    public void setThermostatMode(ThermostatMode mode);
    public boolean isCooling();
}
