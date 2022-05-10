package com.fmgarcia.umbrella.notifications.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @GetMapping
    public ResponseEntity<String>testNotifications(){
        return ResponseEntity.ok("Mi primera notificacion...");
    }
}
