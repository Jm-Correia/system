package com.home.smart.system.model;



import com.home.smart.system.enums.Category;
import com.home.smart.system.errors.SpeedIntegityException;

public class Fan extends Device implements ActionFanInterface {

    
    private static int VELOCITY_ZERO = 0;
    private static int VELOCITY_ONE = 1;
    private static int VELOCITY_TWO = 2;
    
    private int speed;
     
    public Fan(String name, Category category) {
        super(name, category);
        this.speed = VELOCITY_ZERO;
    }

    @Override
    public void turnOn() {
        this.speed = VELOCITY_ONE;
    }

    @Override
    public void turnOff() {
        this.speed = VELOCITY_ZERO;
    }

    @Override
    public boolean status() {
        return speed != 0; //
    }

    @Override
    public void setSpeed(int speed) {
       if(speed < VELOCITY_ZERO || speed > VELOCITY_TWO){
         throw new SpeedIntegityException("Speed Invalid");
       }
       this.speed = speed;
    }

    @Override
    public int getSpeed() {
       return this.speed;
    }

    @Override
    public boolean isAppliance(String uuid) {
        return getId().toString().equals(uuid);
    }
    
}
