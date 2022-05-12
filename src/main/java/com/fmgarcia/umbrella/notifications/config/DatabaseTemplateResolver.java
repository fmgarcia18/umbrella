package com.fmgarcia.umbrella.notifications.config;

import com.fmgarcia.umbrella.notifications.domain.EmailTemplate;
import com.fmgarcia.umbrella.notifications.repository.EmailTemplateRepository;
import jdk.nashorn.internal.runtime.options.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.IEngineConfiguration;
import org.thymeleaf.templateresolver.StringTemplateResolver;
import org.thymeleaf.templateresource.ITemplateResource;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Slf4j
//@Component
public class DatabaseTemplateResolver extends StringTemplateResolver {

    private final EmailTemplateRepository emailTemplateRepository;

    public DatabaseTemplateResolver(EmailTemplateRepository templateRepository) {
        this.emailTemplateRepository = templateRepository;
        this.setResolvablePatterns(Collections.singleton("Template-*"));
        this.setCacheTTLMs(5 * 60 * 1000L);
        this.setCacheable(true);
    }

    @Override
    protected ITemplateResource computeTemplateResource(IEngineConfiguration configuration, String ownerTemplate,
                                                        String templateName, Map<String, Object> templateResolutionAttributes) {
       log.info("Loading template named {} from DB", templateName);
        Optional<EmailTemplate> template = emailTemplateRepository.findByName(templateName);
        if (template.isPresent()) {
            return super.computeTemplateResource(configuration, ownerTemplate, template.get().getContent(),
                    templateResolutionAttributes);

        }

        return null;
    }
}
