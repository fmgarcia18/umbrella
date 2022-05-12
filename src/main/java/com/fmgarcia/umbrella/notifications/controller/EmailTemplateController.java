package com.fmgarcia.umbrella.notifications.controller;

import com.fmgarcia.umbrella.notifications.domain.EmailTemplate;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateNewRequest;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateResponseDTO;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateUpdateDTO;
import com.fmgarcia.umbrella.notifications.service.EmailTemplateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/emails")
public class EmailTemplateController {

    private final EmailTemplateService emailTemplateService;

    @PostMapping
    public ResponseEntity<?> createEmailTemplate(@Valid @RequestBody EmailTemplateNewRequest request){
        log.info(request.toString());
        EmailTemplateResponseDTO emailTemplate = emailTemplateService.createEmailTemplate(request);

        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emailTemplate.getUuid())
                .toUri());

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<EmailTemplateResponseDTO>> getAllEmailTemplates(){
        return ResponseEntity.ok(emailTemplateService.findAllEmailTemplates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailTemplateResponseDTO> getEmailTemplateById(@PathVariable String id){
        return ResponseEntity.ok(emailTemplateService.findByUuid(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailTemplateResponseDTO> updateEmailTemplate(@PathVariable String id, @Valid @RequestBody EmailTemplateUpdateDTO request){
        return ResponseEntity.ok(emailTemplateService.updateByUuid(request));
    }
}
