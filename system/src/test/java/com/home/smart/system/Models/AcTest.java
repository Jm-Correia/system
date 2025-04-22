package com.home.smart.system.Models;

import com.home.smart.system.enums.Category;
import com.home.smart.system.enums.ThermostatMode;
import com.home.smart.system.model.AirConditioner;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AcTest {

    private AirConditioner ac;

    @BeforeEach
    void init(){
        ac = new AirConditioner("Midea U-Shape", Category.CONVENIENCE);
    }

    @Test
    void setModeHeat(){
        ac.setThermostatMode(ThermostatMode.HEAT);
        assertEquals(ac.isCooling(), false, "AC Should not be colling");
    }

    @Test
    void isOnAndColling(){
        ac.turnOn();
        assertEquals(ac.status(), Boolean.TRUE, "Ac should be on");
        assertEquals(ac.isCooling(), Boolean.TRUE, "Ac Should be colling");
    }

}
