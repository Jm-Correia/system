package com.home.smart.system.service;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.smart.system.enums.Category;
import com.home.smart.system.model.AirConditioner;
import com.home.smart.system.model.Fan;
import com.home.smart.system.model.Light;

import static org.junit.jupiter.api.Assertions.*;

public class DevicesManagerServiceTest {

    private DevicesManagerService service;
    private Fan fan;
    private AirConditioner ac;
    private Light light;

    @BeforeEach
    void init(){
        fan = new Fan("WindFlow 2000", Category.COMFORT);
        ac = new AirConditioner("Midea U-Shape", Category.CONVENIENCE);
        light =  new Light("NORMA", Category.ENERGYMANAGER);
        service = new DevicesManagerService();
        service.setAppliances(List.of(fan, ac, light));
    }

    @Test
    void getReturnAllThreeAppliances(){
        assertEquals(3, service.getAll().size(), "Should have 3 devices");
    }

    @Test
    void turnOffALLDevices(){
        light.turnOn(); fan.turnOn(); ac.turnOn();
        service.turnOff();
        assertFalse(light.status(), "Light should be off");
        assertFalse(fan.status(), "Fan should be off");
        assertFalse(ac.status(), "AC should be off");
    }
    
}
