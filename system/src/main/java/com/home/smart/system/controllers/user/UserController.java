package com.home.smart.system.controllers.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.smart.system.model.ApplianceInterface;
import com.home.smart.system.service.DevicesManagerService;

@RestController
@RequestMapping("/user/devices")
public class UserController {
    
    private final DevicesManagerService service;

    public UserController(DevicesManagerService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/{uuid}/on")
    public ResponseEntity<Void> turnOn(@PathVariable String uuid){
        ApplianceInterface d = service.getById(uuid);
        if(d == null){
            return ResponseEntity.notFound().build();
        }
        d.turnOn();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{uuid}/off")
    public ResponseEntity<Void> turnOff(@PathVariable String uuid){
        ApplianceInterface d = service.getById(uuid);
        if(d == null){
            return ResponseEntity.notFound().build();
        }
        d.turnOff();
        return ResponseEntity.ok().build();
    }

}
