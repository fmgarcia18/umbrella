package com.fmgarcia.umbrella.notifications.service;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.StringTemplateResolver;

import java.util.Locale;
import java.util.Map;

@Service
public class TemplateEngineService {

    private TemplateEngine templateEngine;

    private final static String TEMPLATE_LOCAL = "US";

    private TemplateEngine getTemplateEngine() {
        if (null == templateEngine) {
            templateEngine = new TemplateEngine();
            StringTemplateResolver templateResolver = new StringTemplateResolver();
            templateResolver.setTemplateMode(TemplateMode.HTML);
            templateEngine.setTemplateResolver(templateResolver);
        }
        return templateEngine;
    }

    public String getTemplateFromMap(String htmlContent, Map<String, Object> dynamicAttributesMap) {
        templateEngine = getTemplateEngine();
        String template = null;
        final Context ctx = new Context(new Locale(TEMPLATE_LOCAL));
        if (!CollectionUtils.isEmpty(dynamicAttributesMap)) {
            dynamicAttributesMap.forEach((k, v) -> ctx.setVariable(k, v));
        }
        if (null != templateEngine) {
            template = templateEngine.process(htmlContent, ctx);
        }
        return template;
    }
}
