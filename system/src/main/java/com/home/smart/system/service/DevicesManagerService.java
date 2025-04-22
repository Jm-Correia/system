package com.home.smart.system.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.home.smart.system.enums.Category;
import com.home.smart.system.model.AirConditioner;
import com.home.smart.system.model.ApplianceInterface;
import com.home.smart.system.model.Fan;
import com.home.smart.system.model.Light;

import jakarta.annotation.PostConstruct;

@Service
public class DevicesManagerService {
    
    private List<ApplianceInterface> appliances;
    
    @PostConstruct
    public void init(){
        if(!"test".equals(System.getProperty("env"))){
            var ac = new AirConditioner("AC-001", Category.COMFORT);
            var light = new Light("Philips", Category.ENERGYMANAGER);
            var fan = new Fan("Honeywell HT900C", Category.COMFORT);
            appliances = Arrays.asList(ac, light, fan);
            System.out.println("Devices Manager has been initialized.");
            System.out.println(appliances.size());
        }
    }

    public void setAppliances(List<ApplianceInterface> devices){
        this.appliances = devices;
    }

    public List<ApplianceInterface> getAll(){
        return appliances;
    }

    public void turnOff(){
        appliances
            .stream()
            .forEach(device -> device.turnOff());
    }

    public ApplianceInterface getById(String uuid){
        return getAll()
            .stream()
            .filter(p -> p.isAppliance(uuid))
            .findFirst().get();
    }
}
