package com.home.smart.system.errors;

public class SpeedIntegityException extends RuntimeException {
    
    public SpeedIntegityException(String arg0, Throwable arg2){
        super(arg0, arg2);
    }
    public SpeedIntegityException(String arg){
        super(arg);
    }
}
