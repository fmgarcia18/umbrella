package com.fmgarcia.umbrella.notifications.mappers;

import com.fmgarcia.umbrella.notifications.domain.EmailTemplate;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateNewRequest;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateResponseDTO;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmailTemplateMapper {

    EmailTemplate toEmailTemplate(EmailTemplateNewRequest request);

    EmailTemplateResponseDTO toResponseDTO(EmailTemplate emailTemplate);

    Iterable<EmailTemplateResponseDTO> toEmailTemplateDTOs(Iterable<EmailTemplate> emailTemplates);

    EmailTemplate toEmailTemplate(EmailTemplateUpdateDTO request);

}
