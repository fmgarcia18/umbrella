package com.fmgarcia.umbrella.notifications.service;

import com.fmgarcia.umbrella.notifications.domain.EmailTemplate;
import com.fmgarcia.umbrella.notifications.dtos.EmailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender sender;

    private final EmailTemplateService emailTemplateService;

    private final TemplateEngineService templateEngineService;

    @Override
    public void sendEmail(EmailRequest emailRequest) {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        EmailTemplate emailTemplate = emailTemplateService.findByName(emailRequest.getTemplate());
        Map<String, Object> context = new HashMap<>();
        context.put("pageTitle", "Taming Thymeleaf");
        String result = templateEngineService.getTemplateFromMap(emailTemplate.getContent(), context);

        //boolean html = "HTML".equals(emailTemplate.getType()) ? true : false;

        try{
            helper.setTo(emailRequest.getEmail());
            helper.setText(result, true);
            helper.setSubject(emailTemplate.getSubject());

            sender.send(message);

            log.info("enviando email " + emailRequest.toString());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
