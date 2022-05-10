package com.fmgarcia.umbrella.notifications.service;

import com.fmgarcia.umbrella.notifications.dtos.EmailRequest;

public interface EmailService {
    public void sendEmail(EmailRequest emailRequest);
}
