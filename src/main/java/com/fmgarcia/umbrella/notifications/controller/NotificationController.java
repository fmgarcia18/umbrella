package com.fmgarcia.umbrella.notifications.controller;

import com.fmgarcia.umbrella.notifications.dtos.EmailRequest;
import com.fmgarcia.umbrella.notifications.service.EmailService;
import com.fmgarcia.umbrella.notifications.service.EmailTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final EmailService emailService;

    @GetMapping
    public ResponseEntity<String>testNotifications(){
        EmailRequest emailRequest = EmailRequest.builder()
                .email("fmgarcia@mailinator.com")
                .content("Congratulations your firts email from heroku !!!")
                .subject("Test send email")
                .template("Template-2")
                .build();

        emailService.sendEmail(emailRequest);

        return ResponseEntity.ok("Mi primera notificacion !!!");
    }
}
