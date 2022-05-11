package com.fmgarcia.umbrella.notifications.controller;

import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateNewRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/emails")
public class EmailTemplateController {

    @PostMapping
    public ResponseEntity<String> createTemplate(@Valid @RequestBody EmailTemplateNewRequest request){
        log.info(request.toString());
        return ResponseEntity.ok("template created...");
    }

    @GetMapping
    public ResponseEntity<String> getAllTemplates(){
        return ResponseEntity.ok("get all template created...");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getTemplateById(@PathVariable String id){
        return ResponseEntity.ok("get template By Id...");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTemplate(@PathVariable String id){
        return ResponseEntity.ok("update template ...");
    }
}
