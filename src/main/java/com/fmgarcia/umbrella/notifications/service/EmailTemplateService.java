package com.fmgarcia.umbrella.notifications.service;

import com.fmgarcia.umbrella.notifications.domain.EmailTemplate;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateNewRequest;

public interface EmailTemplateService {

    public EmailTemplate createEmailTemplate(EmailTemplateNewRequest emailTemplateNewRequest);
}
