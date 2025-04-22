package com.home.smart.system.model;

import java.util.UUID;

import com.home.smart.system.enums.Category;


public abstract class Device {
    private UUID id;
    private String name;
    private Category category;


    public Device(String name, Category category){
        this.id = UUID.randomUUID();
        this.name = name;
        this.category = category;
    }

    public UUID getId(){
        return id;
    }

    public String getString(){
        return name;
    }

    public String getCategory() {
        return category.name();
    }
}
