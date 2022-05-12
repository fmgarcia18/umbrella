package com.fmgarcia.umbrella.notifications.service;

import com.fmgarcia.umbrella.advice.EntityNotFoundException;
import com.fmgarcia.umbrella.notifications.domain.EmailTemplate;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateNewRequest;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateResponseDTO;
import com.fmgarcia.umbrella.notifications.dtos.EmailTemplateUpdateDTO;
import com.fmgarcia.umbrella.notifications.mappers.EmailTemplateMapper;
import com.fmgarcia.umbrella.notifications.repository.EmailTemplateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailTemplateServiceImpl implements EmailTemplateService{

    private final EmailTemplateMapper mapper;

    private final EmailTemplateRepository repository;

    @Override
    public EmailTemplateResponseDTO createEmailTemplate(EmailTemplateNewRequest emailTemplateNewRequest) {

        EmailTemplate emailTemplate = mapper.toEmailTemplate(emailTemplateNewRequest);

        EmailTemplate newEmailTemplate = repository.save(emailTemplate);

        EmailTemplateResponseDTO responseDTO = mapper.toResponseDTO(newEmailTemplate);

        return responseDTO;
    }

    @Override
    public Iterable<EmailTemplateResponseDTO> findAllEmailTemplates() {

        Iterable<EmailTemplate> emailTemplates = repository.findAll();

        Iterable<EmailTemplateResponseDTO> emailTemplateResponseDTOS = mapper.toEmailTemplateDTOs(emailTemplates);

        return emailTemplateResponseDTOS;
    }

    @Override
    public EmailTemplateResponseDTO findByUuid(String id) {

        EmailTemplate emailTemplate = repository.findByUuid(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));

        EmailTemplateResponseDTO responseDTO = responseDTO = mapper.toResponseDTO(emailTemplate);

        return responseDTO;
    }

    @Override
    public EmailTemplateResponseDTO updateByUuid(EmailTemplateUpdateDTO emailTemplateUpdateDTO) {

        EmailTemplate emailTemplate = repository.findByUuid(emailTemplateUpdateDTO.getUuid()).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));

        EmailTemplate tmpEmailTemplate = mapper.toEmailTemplate(emailTemplateUpdateDTO);
        tmpEmailTemplate.setId(emailTemplate.getId());
        log.info(tmpEmailTemplate.toString());
        EmailTemplate emailTemplateUpdated = repository.save(tmpEmailTemplate);

        EmailTemplateResponseDTO responseDTO = mapper.toResponseDTO(emailTemplateUpdated);

        return responseDTO;
    }

    @Override
    public EmailTemplate findByName(String name) {

        EmailTemplate emailTemplate = repository.findByName(name).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));;
        
        return emailTemplate;
    }
}
