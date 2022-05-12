package com.fmgarcia.umbrella.notifications.service;

import com.fmgarcia.umbrella.notifications.domain.EmailTemplate;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateNewRequest;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateResponseDTO;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateUpdateDTO;

public interface EmailTemplateService {

    public EmailTemplateResponseDTO createEmailTemplate(EmailTemplateNewRequest emailTemplateNewRequest);

    public Iterable<EmailTemplateResponseDTO> findAllEmailTemplates();

    public EmailTemplateResponseDTO findByUuid(String id);

    public EmailTemplateResponseDTO updateByUuid(EmailTemplateUpdateDTO emailTemplateUpdateDTO);

    public EmailTemplate findByName(String name);
}
