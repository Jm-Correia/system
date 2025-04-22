package com.home.smart.system.service;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class JobConfig {
    
    private DevicesManagerService service;

    public JobConfig(DevicesManagerService service){
        this.service = service;
    }

    @Scheduled(cron = "0 0 1 1 1 *")
    public void annualUpdate(){
        service.turnOff();
        var dateTime = LocalDateTime.now();
        String msg = String.format("[ %s ] Annual Update have been done. All appliances are OFF", dateTime);
        System.out.println(msg);
    }

}
