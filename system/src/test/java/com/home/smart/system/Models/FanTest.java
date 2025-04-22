package com.home.smart.system.Models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.home.smart.system.enums.Category;
import com.home.smart.system.errors.SpeedIntegityException;
import com.home.smart.system.model.Fan;

import static org.junit.jupiter.api.Assertions.*;

public class FanTest {
    
    private Fan fan;

    @BeforeEach
    void init(){
        fan = new Fan("3000 WLC", Category.COMFORT);
    }

    @Test
    void fanInitialOff(){
        assertFalse(fan.status(), "Fan Should be off by default");
    }

    @Test
    void turnONFan(){
        fan.turnOn();
        assertTrue(fan.status(), "Fan Should be ON");
        assertEquals(fan.getSpeed(), 1, "Fan Should be slow (SPEED 1)");
    }

    @Test
    void setVelocityTwo(){
        fan.setSpeed(2);
        assertEquals(fan.getSpeed(), 2, "Fan Should work fast (SPEED 2)");
    }

    @Test
    void fanOnOff(){
        fan.turnOn();
        fan.turnOff();
        assertEquals(fan.status(), false);
    }

    @Test
    void setSpeedThreeError(){
        Exception exception = assertThrows(SpeedIntegityException.class, () ->{
            fan.setSpeed(3);
        });
        String msg = "Speed Invalid";
        assertTrue(exception.getMessage().contains(msg), "Fan Should Throw a Error When we try to setup speed out of range");
    }

}
